package tml.centralapi.validatormain.controller;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.model.IntendedOfferUpload;
import tml.centralapi.validatormain.repository.StopRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

@RestController
@RequestMapping("/pg-api/")
@CrossOrigin("*")
public class StopsController {
    @Autowired
    StopRepository stopRepository;

    @GetMapping("/stops/{id}")
    HttpEntity<List<GtfsStopIntendedOffer>> get(@PathVariable String id) throws Exception {
        try {
            List<GtfsStopIntendedOffer> list = stopRepository.findByFeedId(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/stops")
    public GtfsStopIntendedOffer create(@Valid @RequestBody GtfsStopIntendedOffer employee) {
        return stopRepository.save(employee);
    }

    @PutMapping("/stops/{id}")
    public ResponseEntity<GtfsStopIntendedOffer> update(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody GtfsStopIntendedOffer details) throws Exception {
        try {
            GtfsStopIntendedOffer stop = stopRepository.findByStopId(id);
            stop.setStopCode(details.getStopCode());
            stop.setStopDesc(details.getStopDesc());
            stop.setStopName(details.getStopName());
            stop.setStopRemarks(details.getStopRemarks());
            stop.setStopLat(details.getStopLat());
            stop.setStopLon(details.getStopLon());
            stop.setZoneShift(details.getZoneShift());
            stop.setLocationType(details.getLocationType());
            stop.setParentStation(details.getParentStation());
            stop.setWheelchairBoarding(details.getWheelchairBoarding());
            stop.setPlatformCode(details.getPlatformCode());
            stop.setEntranceRestriction(details.getEntranceRestriction());
            stop.setExitRestriction(details.getExitRestriction());
            stop.setSlot(details.getSlot());
            stop.setSignalling(details.getSignalling());
            stop.setShelter(details.getShelter());
            stop.setBench(details.getBench());
            stop.setNetworkMap(details.getNetworkMap());
            stop.setSchedule(details.getSchedule());
            stop.setRealTimeInformation(details.getRealTimeInformation());
            stop.setTariff(details.getTariff());
            stop.setPreservationState(details.getPreservationState());
            stop.setEquipment(details.getEquipment());
            stop.setObservations(details.getObservations());
            stop.setRegion(details.getRegion());
            stop.setMunicipality(details.getMunicipality());
            stop.setMunicipalityFare1(details.getMunicipalityFare1());
            stop.setMunicipalityFare2(details.getMunicipalityFare2());
            final GtfsStopIntendedOffer updatedStop = stopRepository.save(stop);
            return ResponseEntity.ok(updatedStop);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stops/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
            throws Exception {
        GtfsStopIntendedOffer employee = stopRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        stopRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
