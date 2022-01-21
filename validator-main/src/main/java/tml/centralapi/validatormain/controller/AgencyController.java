package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.Agency;
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
    HttpEntity<List<Agency>> get(@PathVariable String id) throws Exception {
        try {
            List<Agency> list = agencyRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agency")
    public Agency create(@Valid @RequestBody Agency agency) {
        return agencyRepository.save(agency);
    }

    @PutMapping("agency")
    public ResponseEntity<Agency> update(@Valid @RequestBody Agency details) throws Exception {
        try {
            final Agency updatedAgency = agencyRepository.save(details);
            return ResponseEntity.ok(updatedAgency);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/agency/{id}")
    public Map<String, Boolean> deleteAgency(@PathVariable(value = "id") String id)
            throws Exception {
        Agency employee = agencyRepository.findByAgencyId(id);
        agencyRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
