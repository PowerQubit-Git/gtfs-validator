package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;

import java.util.List;

public interface StopRepository  extends JpaRepository<GtfsStopIntendedOffer, Long> {
    List<GtfsStopIntendedOffer> findByFeedId(String id);
    GtfsStopIntendedOffer findByStopId(String id);
}
