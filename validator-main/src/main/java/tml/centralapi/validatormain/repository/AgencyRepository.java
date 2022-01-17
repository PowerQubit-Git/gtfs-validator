package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;

import java.util.List;

public interface AgencyRepository extends JpaRepository<GtfsAgencyIntendedOffer, Long> {
    List<GtfsAgencyIntendedOffer> findByFeedId(String id);
    GtfsAgencyIntendedOffer findByAgencyId(String id);
}
