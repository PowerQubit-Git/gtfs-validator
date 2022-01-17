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

    @PostMapping("/routes")
    public GtfsRouteIntendedOffer create(@Valid @RequestBody GtfsRouteIntendedOffer route) {
        return routeRepository.save(route);
    }

    @PutMapping("/routes/{id}")
    public ResponseEntity<GtfsRouteIntendedOffer> update(@PathVariable(value = "id") String id,
                                                        @Valid @RequestBody GtfsRouteIntendedOffer details) throws Exception {
        try {
            GtfsRouteIntendedOffer route = routeRepository.findByRouteId(id);
            route.setLineId(details.getLineId());
            route.setLineShortName(details.getLineShortName());
            route.setLineLongName(details.getLineLongName());
            route.setRouteId(details.getRouteId());
            route.setAgencyId(details.getAgencyId());
            route.setRouteOrigin(details.getRouteOrigin());
            route.setRouteDestination(details.getRouteDestination());
            route.setRouteShortName(details.getRouteShortName());
            route.setRouteLongName(details.getRouteLongName());
            route.setRouteDesc(details.getRouteDesc());
            route.setRouteRemarks(details.getRouteRemarks());
            route.setRouteType(details.getRouteType());
            route.setContract(details.getContract());
            route.setPathType(details.getPathType());
            route.setCircular(details.getCircular());
            route.setSchool(details.getSchool());
            route.setContinuousPickup(details.getContinuousPickup());
            route.setContinuousDropOff(details.getContinuousDropOff());
            final GtfsRouteIntendedOffer updatedRoutes = routeRepository.save(route);
            return ResponseEntity.ok(updatedRoutes);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/routes/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
            throws Exception {
        GtfsRouteIntendedOffer route = routeRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        routeRepository.delete(route);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
