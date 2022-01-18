package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopTimeCompositeKey;
import tml.centralapi.validatormain.model.GtfsStopTimeIntendedOffer;

import java.util.List;

public interface StopTimeRepository extends JpaRepository<GtfsStopTimeIntendedOffer, GtfsStopTimeCompositeKey> {
    List<GtfsStopTimeIntendedOffer> findByFeedId(String id);
}
