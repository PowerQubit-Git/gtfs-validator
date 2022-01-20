package tml.centralapi.validatormain.controller;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.mobilitydata.gtfsvalidator.table.GtfsFeedContainer;
import org.mobilitydata.gtfsvalidator.table.GtfsTableContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tml.centralapi.validatormain.model.*;
import tml.centralapi.validatormain.repository.AgencyRepository;
import tml.centralapi.validatormain.repository.IntendedOfferUploadRepository;
import tml.centralapi.validatormain.services.ValidatorAsyncService;
import tml.centralapi.validatormain.table.GtfsAgencySchema;

import java.util.*;

@RestController
@CrossOrigin("*")
public class IntendedOfferUploadController extends GtfsFeedContainer {
    
    @Autowired
    IntendedOfferUploadRepository mongoRepository;

    @Autowired
    ValidatorAsyncService service;

    public IntendedOfferUploadController(List<GtfsTableContainer<?>> tableContainerList) {
        super(tableContainerList);
    }

    @PostMapping("/intended-offer-upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("user") String publisher) {
        try {
//            csvAgency = super.getTable(Agency).getEntities().size();
//            ValidatorAsyncService valid = new ValidatorAsyncService();
            IntendedOfferUpload uhm = new IntendedOfferUpload();
            Date date = new Date();
            uhm.setUploadDate(date);
            uhm.setPublisherName(publisher);
            uhm.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            mongoRepository.save(uhm);
            service.setInput(uhm);
            service.validateAsync();
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
        ResponseMessage rm = new ResponseMessage("Sucesso!!!");
        return ResponseEntity.status(HttpStatus.OK).body(rm);
    }

    @GetMapping("/uploads")
    List<IntendedOfferUpload> getUploads() {
        List<IntendedOfferUpload> list = mongoRepository.findAll();
        list.forEach(m -> {
            m.setFile(null);
        });
        return list;
    }

    @GetMapping("/download/{id}")
    HttpEntity<byte[]> one(@PathVariable String id) throws Exception {
        IntendedOfferUpload m = mongoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        Binary file = m.getFile();
        byte[] documentBody = file.getData();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.MULTIPART_RELATED);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + id + ".zip");
        header.setContentLength(documentBody.length);

        return new HttpEntity<>(documentBody, header);
    }

    @GetMapping("validations/{id}")
    Notices GetValidationsReport(@PathVariable String id) throws Exception {
        IntendedOfferUpload m = mongoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        return m.getValidationReport();
    }

    @GetMapping("errors/{id}")
    Notices GetErrorsReport(@PathVariable String id) throws Exception {
        IntendedOfferUpload m = mongoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        return m.getErrorsReport();
    }

    @GetMapping("explorer/{id}")
    List<TableResume> GetFilesResume(@PathVariable String id) throws Exception {
        IntendedOfferUpload m = mongoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        return m.getTableResumeList();
    }

}
