package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.StopTime;
import tml.centralapi.validatormain.repository.StopTimeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StopTimesController {
    @Autowired
    StopTimeRepository stopTimeRepository;

    @GetMapping("/stop_times/{id}")
    HttpEntity<List<StopTime>> get(@PathVariable String id) throws Exception {
        try {
            List<StopTime> list = stopTimeRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/stop_times")
    public StopTime create(@Valid @RequestBody StopTime stopTimes) {
        return stopTimeRepository.save(stopTimes);
    }

//    @PutMapping("/stop_times/{id}")
//    public ResponseEntity<GtfsStopTimeIntendedOffer> update(@PathVariable(value = "id") String id,
//                                                        @Valid @RequestBody GtfsStopTimeIntendedOffer details) throws Exception {
//        try {
//            GtfsStopTimeIntendedOffer stopTimes = stopTimeRepository.findByStopTimeId(id);
//            stopTimes.setTripId(details.getTripId());
//            stopTimes.setArrivalTime(details.getArrivalTime());
//            stopTimes.setDepartureTime(details.getDepartureTime());
//            stopTimes.setStopId(details.getStopId());
//            stopTimes.setStopSequence(details.getStopSequence());
//            stopTimes.setStopHeadsign(details.getStopHeadsign());
//            stopTimes.setContinuousPickup(details.getContinuousPickup());
//            stopTimes.setContinuousDropOff(details.getContinuousDropOff());
//            stopTimes.setShapeDistTraveled(details.getShapeDistTraveled());
//            stopTimes.setTimepoint(details.getTimepoint());
//            final GtfsStopTimeIntendedOffer updatedStopTimes = stopTimeRepository.save(stopTimes);
//            return ResponseEntity.ok(updatedStopTimes);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @DeleteMapping("/stop_times/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
//            throws Exception {
//        GtfsStopTimeIntendedOffer stopTimes = stopTimeRepository.findById(id)
//                .orElseThrow(() -> new Exception("not found"));
//
//        stopTimeRepository.delete(stopTimes);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}
