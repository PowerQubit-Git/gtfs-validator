package tml.centralapi.validatormain.controller;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tml.centralapi.validatormain.model.IntendedOfferUpload;
import tml.centralapi.validatormain.model.ResponseMessage;
import tml.centralapi.validatormain.repository.IntendedOfferUploadRepository;
import tml.centralapi.validatormain.services.ValidatorAsyncService;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class IntendedOfferUploadController {

    @Autowired
    IntendedOfferUploadRepository mongoRepository;

    @Autowired
    ValidatorAsyncService service;

    @PostMapping("/intended-offer-upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("user") String publisher) {
        try {
            IntendedOfferUpload uhm = new IntendedOfferUpload();
            Date date = new Date();
            uhm.setUploadDate(date);
            uhm.setPublisherName(publisher);
            uhm.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            mongoRepository.save(uhm);

            String id = uhm.getId();
            System.out.println("Inserted ID: " + id);

            service.setInput(uhm);
            service.validateAsync();
            service.asyncMethod();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
        ResponseMessage rm = new ResponseMessage("Sucesso!!!");
        return ResponseEntity.status(HttpStatus.OK).body(rm);
    }
}
