package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;
import tml.centralapi.validatormain.model.GtfsShapeIntendedOffer;

import java.util.List;

public interface ShapeRepository extends JpaRepository<GtfsShapeIntendedOffer, Long> {
    List<GtfsShapeIntendedOffer> findByFeedId(String id);
    GtfsShapeIntendedOffer findByShapeId(String id);
}
