package tml.centralapi.validatormain.controller;

import com.beust.jcommander.JCommander;
import com.google.common.base.Strings;
import com.google.common.flogger.FluentLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mobilitydata.gtfsvalidator.input.CountryCode;
import org.mobilitydata.gtfsvalidator.input.CurrentDateTime;
import org.mobilitydata.gtfsvalidator.input.GtfsInput;
import org.mobilitydata.gtfsvalidator.notice.IOError;
import org.mobilitydata.gtfsvalidator.notice.NoticeContainer;
import org.mobilitydata.gtfsvalidator.notice.NoticeSchemaGenerator;
import org.mobilitydata.gtfsvalidator.notice.URISyntaxError;
import org.mobilitydata.gtfsvalidator.table.*;
import org.mobilitydata.gtfsvalidator.validator.DefaultValidatorProvider;
import org.mobilitydata.gtfsvalidator.validator.ValidationContext;
import org.mobilitydata.gtfsvalidator.validator.ValidatorLoader;
import org.mobilitydata.gtfsvalidator.validator.ValidatorLoaderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tml.centralapi.validatormain.model.*;
import tml.centralapi.validatormain.repository.UploadHistoricRepository;
import tml.centralapi.validatormain.services.FileStorageService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class FileController {

    @Autowired
    FileStorageService storageService;

    @Autowired
    UploadHistoricRepository uploadHistoricRepository;

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            UUID fName = storageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();

            String filePath = "C:\\Users\\dgxcs\\Documents\\Git\\uploads\\" + fName + ".zip";
            Arguments arg = new Arguments(
                    filePath
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
            ValidationResult vr = vc.loadFeed(arg);

            if (vr.isSuccess()) {
                try {
                    UploadHistoric uh = new UploadHistoric( "NameTeste", "2022-01-06 22:00", fName + ".zip");
                    uploadHistoricRepository.save(uh);
                    System.out.println("##################################### " + uh.getId());

                    GtfsFeedContainer x = vr.getFeedContainer();

                    Map<String, GtfsTableContainer<?>> map;

                    map = x.getTables();

                    map.forEach( (k,v) ->{
                        System.out.println("Key: " + k + ": Value: " + v);

                        switch (k){
                            /*case "stops.txt":
                                List<GtfsStop> stops = (List<GtfsStop>) v.getEntities();
                                break;*/
                            case "agency.txt":
                                List<GtfsAgency> agencies = (List<GtfsAgency>) v.getEntities();

                                agencies.forEach( (agency) ->{
                                    GtfsAgencyIntendedOffer a = new GtfsAgencyIntendedOffer();

                                    a.setAgencyId(agency.agencyId());
                                });

                                break;
                        }

                    });


                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            Gson gson = new Gson();
            String jsonString = gson.toJson(vr);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(jsonString));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

}
