package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.Trip;
import tml.centralapi.validatormain.repository.TripRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class TripController {
    @Autowired
    TripRepository tripRepository;

    @GetMapping("/trips/{id}")
    HttpEntity<List<Trip>> get(@PathVariable String id) throws Exception {
        try {
            List<Trip> list = tripRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/trips")
    public Trip create(@Valid @RequestBody Trip Trip) {
        return tripRepository.save(Trip);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> update(@PathVariable(value = "id") String id,
                                       @Valid @RequestBody Trip details) throws Exception {
        try {
            Trip trip = tripRepository.findByTripId(id);
            trip.setShapeId(details.getShapeId());
            trip.setBikesAllowed(details.getBikesAllowed());
            trip.setTripId(details.getTripId());
            trip.setTripLast(details.getTripLast());
            trip.setTripFirt(details.getTripFirst());
            trip.setWheelchairAccessible(details.getWheelchairAccessible());
            trip.setRouteId(details.getRouteId());
            trip.setServiceId(details.getServiceId());
            trip.setTripHeadsign(details.getTripHeadsign());
            trip.setFeedId(details.getFeedId());
            trip.setDirectionId(details.getDirectionId());
            final Trip updatedTrip = tripRepository.save(trip);
            return ResponseEntity.ok(updatedTrip);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/trips/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") Long id)
            throws Exception {
        Trip Trip = tripRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        tripRepository.delete(Trip);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
