package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.repository.AgencyRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AgencyController {

    @Autowired
    AgencyRepository agencyRepository;

    @GetMapping("/agency/{id}")
    HttpEntity<List<GtfsAgencyIntendedOffer>> get(@PathVariable String id) throws Exception {
        try {
            List<GtfsAgencyIntendedOffer> list = agencyRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agency")
    public GtfsAgencyIntendedOffer create(@Valid @RequestBody GtfsAgencyIntendedOffer agency) {
        return agencyRepository.save(agency);
    }

    @PutMapping("/agency/{id}")
    public ResponseEntity<GtfsAgencyIntendedOffer> update(@PathVariable(value = "id") String id,
                                                        @Valid @RequestBody GtfsAgencyIntendedOffer details) throws Exception {
        try {
            GtfsAgencyIntendedOffer agency = agencyRepository.findByAgencyId(id);
            agency.setAgencyId(details.getAgencyId());
            agency.setAgencyName(details.getAgencyName());
            agency.setAgencyUrl(details.getAgencyUrl());
            agency.setAgencyTimezone(details.getAgencyTimezone());
            agency.setAgencyLang(details.getAgencyLang());
            final GtfsAgencyIntendedOffer updatedStop = agencyRepository.save(agency);
            return ResponseEntity.ok(updatedStop);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/agency/{id}")
    public Map<String, Boolean> deleteAgency(@PathVariable(value = "id") String id)
            throws Exception {
        GtfsAgencyIntendedOffer employee = agencyRepository.findByAgencyId(id);

        agencyRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
