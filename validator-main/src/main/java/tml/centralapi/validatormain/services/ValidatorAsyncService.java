package tml.centralapi.validatormain.services;

import com.google.common.flogger.FluentLogger;
import com.google.gson.Gson;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.mobilitydata.gtfsvalidator.input.CountryCode;
import org.mobilitydata.gtfsvalidator.input.CurrentDateTime;
import org.mobilitydata.gtfsvalidator.input.GtfsInput;
import org.mobilitydata.gtfsvalidator.input.GtfsZipFileInput;
import org.mobilitydata.gtfsvalidator.notice.IOError;
import org.mobilitydata.gtfsvalidator.notice.NoticeContainer;
import org.mobilitydata.gtfsvalidator.notice.URISyntaxError;
import org.mobilitydata.gtfsvalidator.table.GtfsFeedContainer;
import org.mobilitydata.gtfsvalidator.table.GtfsFeedLoader;
import org.mobilitydata.gtfsvalidator.table.GtfsTableContainer;
import org.mobilitydata.gtfsvalidator.validator.DefaultValidatorProvider;
import org.mobilitydata.gtfsvalidator.validator.ValidationContext;
import org.mobilitydata.gtfsvalidator.validator.ValidatorLoader;
import org.mobilitydata.gtfsvalidator.validator.ValidatorLoaderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import tml.centralapi.validatormain.controller.AgencyController;
import tml.centralapi.validatormain.controller.IntendedOfferUploadController;
import tml.centralapi.validatormain.model.Agency;
import tml.centralapi.validatormain.model.IntendedOfferUpload;
import tml.centralapi.validatormain.model.TableResume;
import tml.centralapi.validatormain.repository.AgencyRepository;
import tml.centralapi.validatormain.repository.IntendedOfferUploadRepository;
import tml.centralapi.validatormain.model.Notices;
import tml.centralapi.validatormain.table.GtfsAgencySchema;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorAsyncService extends GtfsFeedContainer{
    @Autowired
    IntendedOfferUploadRepository mongoRepository;

    @Autowired
    IntendedOfferPgService pgService;

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private static final int numberOfThreads = 1;

    public ValidatorAsyncService(List<GtfsTableContainer<?>> tableContainerList) {
        super(tableContainerList);
    }

    public IntendedOfferUpload getInput() {
        return input;
    }

    public void setInput(IntendedOfferUpload input) {
        this.input = input;
    }

    private IntendedOfferUpload input;

    @Async
    public void validateAsync() throws InterruptedException {
        String id = this.input.getId();
        IntendedOfferUpload upload = null;
        try {
            upload = mongoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.input = upload;

        ValidatorLoader validatorLoader = null;
        try {
            validatorLoader = new ValidatorLoader();
        } catch (ValidatorLoaderException e) {
            logger.atSevere().withCause(e).log("Cannot load validator classes");
            System.exit(1);
        }
        GtfsFeedLoader feedLoader = new GtfsFeedLoader();

        System.out.println("Table loaders: " + feedLoader.listTableLoaders());
        System.out.println("Validators:");
        System.out.println(validatorLoader.listValidators());

        final long startNanos = System.nanoTime();
        // Input.
        feedLoader.setNumThreads(numberOfThreads);
        NoticeContainer noticeContainer = new NoticeContainer();
        GtfsFeedContainer feedContainer;
        GtfsInput gtfsInput = null;

        try {
            byte[] file = this.input.getFile().getData();
            gtfsInput = createGtfsInput(file);
        } catch (IOException e) {
            String err1 = "Cannot load GTFS feed";
            logger.atSevere().withCause(e).log(err1);
            noticeContainer.addSystemError(new IOError(e));
        } catch (URISyntaxException e) {
            String err2 = "Syntax error in URI";
            logger.atSevere().withCause(e).log(err2);
            noticeContainer.addSystemError(new URISyntaxError(e));
        }

        ValidationContext validationContext =
                ValidationContext.builder()
                        .setCountryCode(
                                CountryCode.forStringOrUnknown(CountryCode.ZZ))
                        .setCurrentDateTime(new CurrentDateTime(ZonedDateTime.now(ZoneId.systemDefault())))
                        .build();
        try {
            feedContainer =
                    loadAndValidate(
                            validatorLoader, feedLoader, noticeContainer, gtfsInput, validationContext);
            printSummary(startNanos, feedContainer);

            exportReport(noticeContainer, feedContainer);

            // POSTGRES
            final long startNanosPg = System.nanoTime();
            pgService.setFeedId(id);
            System.out.println("Postgres started agency");
            pgService.addAgencyToDatabase(feedContainer);
            System.out.println("Postgres started stops");
            pgService.addStopsToDatabase(feedContainer);
            System.out.println("Postgres started routes");
            pgService.addRoutesToDatabase(feedContainer);
            System.out.println("Postgres started trips");
            pgService.addTripsToDatabase(feedContainer);
            System.out.println("Postgres started stop_times");
            pgService.addStopTimesToDatabase(feedContainer);
            System.out.println("Postgres started stop_times 5");
            pgService.addCalendarToDatabase(feedContainer);
            pgService.addCalendarDateToDatabase(feedContainer);

            System.out.println("Postgres started shapes");
            //pgService.addShapesToDatabase(feedContainer);
            final long endNanos = System.nanoTime();
            double t = (endNanos - startNanosPg) / 1e9;
            System.out.printf("Postgres took %.3f seconds%n", t);

            //System.out.println(feedContainer.tableTotals());
            // POSTGRES

        } catch (InterruptedException e) {
            String err3 = "Validation was interrupted";
            logger.atSevere().withCause(e).log(err3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** Generates and exports reports for both validation notices and system errors reports. */
    @Async
    public void exportReport(final NoticeContainer noticeContainer, GtfsFeedContainer feedContainer) throws Exception {

        GtfsTableContainer agency = feedContainer.getTableForFilename("agency.txt").orElseThrow(() -> new Exception("agency.txt not found"));
        GtfsTableContainer calendar = feedContainer.getTableForFilename("calendar.txt").orElseThrow(() -> new Exception("calendar.txt not found"));
        GtfsTableContainer calendarDates = feedContainer.getTableForFilename("calendar_dates.txt").orElseThrow(() -> new Exception("calendar_dates.txt not found"));
        GtfsTableContainer feedInfo = feedContainer.getTableForFilename("feed_info.txt").orElseThrow(() -> new Exception("feed_info.txt not found"));
        GtfsTableContainer routes = feedContainer.getTableForFilename("routes.txt").orElseThrow(() -> new Exception("routes.txt not found"));
        GtfsTableContainer shapes = feedContainer.getTableForFilename("shapes.txt").orElseThrow(() -> new Exception("shapes.txt not found"));
        GtfsTableContainer stops = feedContainer.getTableForFilename("stops.txt").orElseThrow(() -> new Exception("stops.txt not found"));
        GtfsTableContainer stopTimes = feedContainer.getTableForFilename("stop_times.txt").orElseThrow(() -> new Exception("stop_times.txt not found"));
        GtfsTableContainer trip = feedContainer.getTableForFilename("trips.txt").orElseThrow(() -> new Exception("trips.txt not found"));


        this.input.setCsvAgency(agency.getEntities().size());
        this.input.setCsvCalendar(calendar.getEntities().size());
        this.input.setCsvCalendarDates(calendarDates.getEntities().size());
        this.input.setCsvFeedInfo( feedInfo.getEntities().size());
        this.input.setCsvRoutes(routes.getEntities().size());
        this.input.setCsvShapes(shapes.getEntities().size());
        this.input.setCsvStops(stops.getEntities().size());
        this.input.setCsvStopTimes(stopTimes.getEntities().size());
        this.input.setCsvTrips(trip.getEntities().size());


        Gson gson = new Gson();
        Notices validations = gson.fromJson(noticeContainer.exportValidationNotices(), Notices.class);
        Notices errors = gson.fromJson(noticeContainer.exportSystemErrors(), Notices.class);
        this.input.setValidationReport(validations);
        this.input.setErrorsReport(errors);


        Map<String, GtfsTableContainer<?>> map = feedContainer.getTables();
        Iterator<Map.Entry<String, GtfsTableContainer<?>>> it = map.entrySet().iterator();
        List<TableResume> resumeList = new ArrayList<>();
        while(it.hasNext()) {
            Map.Entry<String, GtfsTableContainer<?>> pair = it.next();
            String x = pair.getKey() + " - " + pair.getValue().getTableStatus();
            resumeList.add(new TableResume(pair.getKey(), pair.getValue().getTableStatus().toString()));
        }
        this.input.setTableResumeList(resumeList);
        mongoRepository.save(this.input);
    }

    @Async
    public static GtfsInput createGtfsInput(byte[] file) throws IOException, URISyntaxException {
        return new GtfsZipFileInput(new ZipFile(new SeekableInMemoryByteChannel(file)));
    }

    @Async
    public static void printSummary(long startNanos, GtfsFeedContainer feedContainer) {
        final long endNanos = System.nanoTime();
        if (!feedContainer.isParsedSuccessfully()) {
            System.out.println(" ----------------------------------------- ");
            System.out.println("|       !!!    PARSING FAILED    !!!      |");
            System.out.println("|   Most validators were never invoked.   |");
            System.out.println("|   Please see report.json for details.   |");
            System.out.println(" ----------------------------------------- ");
        }
        double t = (endNanos - startNanos) / 1e9;
        System.out.printf("Validation took %.3f seconds%n", t);
        System.out.println(feedContainer.tableTotals());
    }

    @Async
    public static GtfsFeedContainer loadAndValidate(
            ValidatorLoader validatorLoader,
            GtfsFeedLoader feedLoader,
            NoticeContainer noticeContainer,
            GtfsInput gtfsInput,
            ValidationContext validationContext)
            throws InterruptedException {
        GtfsFeedContainer feedContainer;
        feedContainer =
                feedLoader.loadAndValidate(
                        gtfsInput,
                        new DefaultValidatorProvider(validationContext, validatorLoader),
                        noticeContainer);
        return feedContainer;
    }
}
