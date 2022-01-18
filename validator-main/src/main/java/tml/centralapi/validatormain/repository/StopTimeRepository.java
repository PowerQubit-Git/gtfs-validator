package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopTimeIntendedOffer;

import java.util.List;

public interface StopTimeRepository extends JpaRepository<GtfsStopTimeIntendedOffer, Long> {
    List<GtfsStopTimeIntendedOffer> findByFeedId(String id);
    GtfsStopTimeIntendedOffer findByStopTimeId(String id);
}
