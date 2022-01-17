package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsShapeIntendedOffer;
import tml.centralapi.validatormain.model.GtfsTripIntendedOffer;

import java.util.List;

public interface TripRepository  extends JpaRepository<GtfsTripIntendedOffer, Long> {
    List<GtfsTripIntendedOffer> findById(String id);
    GtfsTripIntendedOffer findByTripId(String id);
}
