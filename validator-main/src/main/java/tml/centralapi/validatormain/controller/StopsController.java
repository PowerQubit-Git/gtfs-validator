package tml.centralapi.validatormain.controller;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.model.IntendedOfferUpload;
import tml.centralapi.validatormain.repository.StopRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StopsController {
    @Autowired
    StopRepository stopRepository;

    @GetMapping("/stops/{id}")
    HttpEntity<List<GtfsStopIntendedOffer>> one(@PathVariable String id) throws Exception {
        try {
            List<GtfsStopIntendedOffer> list = stopRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
