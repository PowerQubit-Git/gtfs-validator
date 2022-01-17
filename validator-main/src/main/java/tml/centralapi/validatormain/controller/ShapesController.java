package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;
import tml.centralapi.validatormain.model.GtfsShapeIntendedOffer;
import tml.centralapi.validatormain.repository.FeedInfoRepository;
import tml.centralapi.validatormain.repository.ShapeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ShapesController {
    @Autowired
    ShapeRepository shapeRepository;

    @GetMapping("/shapes/{id}")
    HttpEntity<List<GtfsShapeIntendedOffer>> get(@PathVariable String id) throws Exception {
        try {
            List<GtfsShapeIntendedOffer> list = shapeRepository.findById(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/shapes")
    public GtfsShapeIntendedOffer create(@Valid @RequestBody GtfsShapeIntendedOffer employee) {
        return shapeRepository.save(employee);
    }

    @PutMapping("/shapes/{id}")
    public ResponseEntity<GtfsShapeIntendedOffer> update(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody GtfsShapeIntendedOffer details) throws Exception {
        try {
            GtfsShapeIntendedOffer shapes = shapeRepository.findByShapeId(id);
            shapes.setShapeId(details.getShapeId());
            shapes.setShapeDistTraveled(details.getShapeDistTraveled());
            shapes.setShapePtSequence(details.getShapePtSequence());
            shapes.setShapePtLon(details.getShapePtLon());
            shapes.setShapePtLat(details.getShapePtLat());
            shapes.setFeedId(details.getFeedId());
            final GtfsShapeIntendedOffer updatedShapes = shapeRepository.save(shapes);
            return ResponseEntity.ok(updatedShapes);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/shapes/{id}")
    public Map<String, Boolean> deleteShapes(@PathVariable(value = "id") Long id)
            throws Exception {
        GtfsShapeIntendedOffer Shapes = shapeRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));

        shapeRepository.delete(Shapes);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
