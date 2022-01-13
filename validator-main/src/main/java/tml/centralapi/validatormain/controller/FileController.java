package tml.centralapi.validatormain.controller;

import com.google.common.flogger.FluentLogger;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.logging.Log;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.mobilitydata.gtfsvalidator.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tml.centralapi.validatormain.model.*;
import tml.centralapi.validatormain.repository.*;
import tml.centralapi.validatormain.services.FileStorageService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class FileController {

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    CalendarDateRepository calendarDateRepository;
    @Autowired
    FeedInfoRepository feedInfoRepository;
    @Autowired
    FrequencyRepository frequencyRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    ShapeRepository shapeRepository;
    @Autowired
    StopRepository stopRepository;
    @Autowired
    StopTimeRepository stopTimeRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    FileStorageService storageService;

    @Autowired
    UploadHistoricRepository uploadHistoricRepository;

    @Autowired
    UploadMongoRepository mongoRepository;

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            UUID fName = storageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();

            Arguments arg = new Arguments(
                    file.getBytes()
                    ,null
                    ,"output"
                    ,3
                    ,"feed"
                    ,"pt"
                    ,"x"
                    ,"output"
                    ,"ms_val_rep.txt"
                    ,"ms_err_rep.txt"
                    ,false
                    ,false
                    ,false);

            ValidatorController vc = new ValidatorController();
            JsonObject vr = vc.loadFeed(arg);
            Gson gson = new Gson();
            String jsonString = gson.toJson(vr);

//            UploadHistoric uh = new UploadHistoric( "NameTeste", "2022-01-06 22:00", fName + ".zip",file.getBytes());
//            uploadHistoricRepository.save(uh);
            try {
                UploadHistoricMongo uhm = new UploadHistoricMongo((long)0, "NameTeste", "2022-01-06 22:00", fName + ".zip");
                uhm.setNotices(gson.toJson(vr.getAsJsonArray("notices")));
                uhm.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                mongoRepository.save(uhm);
            } catch(Exception e) {
                    e.printStackTrace(System.out);
                }

//            if (vr.isSuccess()) {
//                try {
//                    UploadHistoric uh = new UploadHistoric( "NameTeste", "2022-01-06 22:00", fName + ".zip",file.getBytes());
//                    uploadHistoricRepository.save(uh);
//                    System.out.println("##################################### " + uh.getId());
//
//                    GtfsFeedContainer x = vr.getFeedContainer();
//
//                    Map<String, GtfsTableContainer<?>> map;
//
//                    map = x.getTables();
//
//                    map.forEach( (k,v) ->{
////                        System.out.println("Key: " + k + ": Value: " + v);
//
//                        switch (k){
//
//                            case "stop_times.txt":
//                                List<GtfsStopTime> stopTimes = (List<GtfsStopTime>) v.getEntities();
//
//                                stopTimes.forEach((stopTime) ->{
//                                    GtfsStopTimeIntendedOffer st = new GtfsStopTimeIntendedOffer();
//
//                                    st.setTripId(stopTime.tripId());
//                                    st.setStopId(stopTime.stopId());
//                                    st.setStopSequence(stopTime.stopSequence());
//                                    st.setStopHeadsign(stopTime.stopHeadsign());
//                                    st.setContinuousPickup(stopTime.continuousPickup());
//                                    st.setContinuousDropOff(stopTime.continuousDropOff());
//                                    st.setShapeDistTraveled(stopTime.shapeDistTraveled());
//                                    st.setTimepoint(stopTime.timepoint());
//
//                                    try {
//                                        stopTimeRepository.save(st);
//                                    } catch (Exception e) {
//                                        System.out.println(e.getMessage());
//                                    }
//
//                                });
//                                break;
//
//                            case "stops.txt":
//                                List<GtfsStop> stops = (List<GtfsStop>) v.getEntities();
//
//                                stops.forEach((stop) ->{
//                                    GtfsStopIntendedOffer s = new GtfsStopIntendedOffer();
//
//                                    s.setStopId(stop.stopId());
//                                    s.setStopCode(stop.stopCode());
//                                    s.setStopName(stop.stopName());
//                                    s.setStopDesc(stop.stopDesc());
//                                    s.setStopLat(stop.stopLat());
//                                    s.setStopLon(stop.stopLon());
//                                    s.setLocationType(stop.locationType());
//                                    s.setParentStation(stop.parentStation());
//                                    s.setWheelchairBoarding(stop.wheelchairBoarding());
//                                    s.setPlatformCode(stop.platformCode());
//
//
//                                    stopRepository.save(s);
//                                });
//                                break;
//
//                           case "agency.txt":
//                                List<GtfsAgency> agencies = (List<GtfsAgency>) v.getEntities();
//
//                                agencies.forEach((agency) ->{
//                                    GtfsAgencyIntendedOffer a = new GtfsAgencyIntendedOffer();
//
//                                    a.setAgencyId(agency.agencyId());
//
//                                    agencyRepository.save(a);
//                                });
//                                break;
//
//                            case "calendar_dates.txt":
//                                List<GtfsCalendarDate> calendarDates = (List<GtfsCalendarDate>) v.getEntities();
//
//                                calendarDates.forEach((calendarDate) ->{
//                                    GtfsCalendarDateIntendedOffer cd = new GtfsCalendarDateIntendedOffer();
//
//                                    cd.setServiceId(calendarDate.serviceId());
//                                    cd.setHoliday(calendarDate.holiday());
//                                    cd.setPeriod(calendarDate.period());
//
//                                    calendarDateRepository.save(cd);
//                                });
//                                break;
//
//
//                            case "calendar.txt":
//                                List<GtfsCalendar> calendars = (List<GtfsCalendar>) v.getEntities();
//
//                                calendars.forEach((calendar) ->{
//                                    GtfsCalendarIntendedOffer c = new GtfsCalendarIntendedOffer();
//
//                                    c.setServiceId(calendar.serviceId());
//                                    c.setCalendarName(calendar.calendarName());
//                                    c.setPeriod(calendar.period());
//                                    c.setMonday(calendar.monday());
//                                    c.setTuesday(calendar.tuesday());
//                                    c.setWednesday(calendar.wednesday());
//                                    c.setThursday(calendar.thursday());
//                                    c.setFriday(calendar.friday());
//                                    c.setSaturday(calendar.saturday());
//                                    c.setSunday(calendar.sunday());
//
//                                    calendarRepository.save(c);
//                                });
//                                break;
//
//                            case "shapes.txt":
//                                List<GtfsShape> shapes = (List<GtfsShape>) v.getEntities();
//
//                                shapes.forEach((shape) ->{
//                                    GtfsShapeIntendedOffer sh = new GtfsShapeIntendedOffer();
//
//                                    sh.setShapeId(shape.shapeId());
//                                    sh.setShapePtLat(shape.shapePtLat());
//                                    sh.setShapePtLon(shape.shapePtLon());
//                                    sh.setShapePtSequence(shape.shapePtSequence());
//                                    sh.setShapeDistTraveled(shape.shapeDistTraveled());
//
//                                    shapeRepository.save(sh);
//                                });
//                                break;
//
//                            case "feed_info.txt":
//                                List<GtfsFeedInfo> feedInfos = (List<GtfsFeedInfo>) v.getEntities();
//
//                                feedInfos.forEach((feedInfo) ->{
//                                    GtfsFeedInfoIntendedOffer fi = new GtfsFeedInfoIntendedOffer();
//
//                                    fi.setFeedVersion(feedInfo.feedVersion());
//                                    fi.setFeedDesc(feedInfo.feedDesc());
//                                    fi.setFeedRemarks(feedInfo.feedRemarks());
//
//                                    feedInfoRepository.save(fi);
//                                });
//                                break;
//
//                            case "routes.txt":
//                                List<GtfsRoute> routes = (List<GtfsRoute>) v.getEntities();
//
//                                routes.forEach((route) ->{
//                                    GtfsRouteIntendedOffer r = new GtfsRouteIntendedOffer();
//
//                                    r.setRouteId(route.routeId());
//                                    r.setAgencyId(route.agencyId());
//                                    r.setRouteShortName(route.routeShortName());
//                                    r.setRouteLongName(route.routeLongName());
//                                    r.setRouteDesc(route.routeDesc());
//                                    r.setRouteType(route.routeType());
//                                    r.setContinuousPickup(route.continuousPickup());
//                                    r.setContinuousDropOff(route.continuousDropOff());
//
//                                    routeRepository.save(r);
//                                });
//                                break;
//
//                            case "trips.txt":
//                                List<GtfsTrip> trips = (List<GtfsTrip>) v.getEntities();
//
//                                trips.forEach((trip) ->{
//                                    GtfsTripIntendedOffer t = new GtfsTripIntendedOffer();
//
//                                    t.setRouteId(trip.routeId());
//                                    t.setTripId(trip.tripId());
//                                    t.setServiceId(trip.serviceId());
//                                    t.setTripHeadsign(trip.tripHeadsign());
//                                    t.setDirectionId(trip.directionId());
//                                    t.setShapeId(trip.shapeId());
//                                    t.setWheelchairAccessible(trip.wheelchairAccessible());
//                                    t.setBikesAllowed(trip.bikesAllowed());
//
//                                    tripRepository.save(t);
//                                });
//                                break;
//
//                        }
//                    });
//
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }

            ResponseMessage rm = new ResponseMessage("Sucesso!!!");

            Notice n = gson.fromJson(vr, Notice.class);
            rm.setValidationResult(n);

            return ResponseEntity.status(HttpStatus.OK).body(rm);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @GetMapping("/uploads")
    List<UploadHistoricMongo> getUploads() {
        List<UploadHistoricMongo> list = mongoRepository.findAll();
        list.forEach(m -> {
            m.setFile(null);
        });
        return list;
    }

    @GetMapping("/download")
    List<UploadHistoricMongo> all() {
        List<UploadHistoricMongo> list = mongoRepository.findAll();
        list.forEach(m -> {
            m.setFile(null);
        });
        return list;
    }

    @GetMapping("/download/{id}")
    HttpEntity<byte[]> one(@PathVariable Long id) {
        UploadHistoricMongo m = mongoRepository.findByfeedId(id);
//                .orElseThrow(() -> new FileNotFoundException(id));
        Binary file = m.getFile();
        String name = m.getFileName();
        byte[] documentBody = file.getData();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.MULTIPART_RELATED);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + name);
        header.setContentLength(documentBody.length);

        return new HttpEntity<byte[]>(documentBody, header);
    }

}
