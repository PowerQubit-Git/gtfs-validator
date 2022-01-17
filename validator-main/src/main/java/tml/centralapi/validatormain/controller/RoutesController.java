package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.GtfsRouteIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.repository.RouteRepository;
import tml.centralapi.validatormain.repository.StopRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pg-api/")
@CrossOrigin("*")
public class RoutesController {
    @Autowired
    RouteRepository routeRepository;

    @GetMapping("/routes/{id}")
    HttpEntity<List<GtfsRouteIntendedOffer>> get(@PathVariable String id) throws Exception {
        try {
            List<GtfsRouteIntendedOffer> list = routeRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/stops")
//    public GtfsStopIntendedOffer create(@Valid @RequestBody GtfsStopIntendedOffer employee) {
//        return stopRepository.save(employee);
//    }
//
//    @PutMapping("/stops/{id}")
//    public ResponseEntity<GtfsStopIntendedOffer> update(@PathVariable(value = "id") String id,
//                                                        @Valid @RequestBody GtfsStopIntendedOffer details) throws Exception {
//        try {
//            GtfsStopIntendedOffer stop = stopRepository.findByStopId(id);
//            stop.setStopCode(details.getStopCode());
//            stop.setStopDesc(details.getStopDesc());
//            final GtfsStopIntendedOffer updatedStop = stopRepository.save(stop);
//            return ResponseEntity.ok(updatedStop);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/stops/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
//            throws Exception {
//        GtfsStopIntendedOffer employee = stopRepository.findById(id)
//                .orElseThrow(() -> new Exception("not found"));
//
//        stopRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
