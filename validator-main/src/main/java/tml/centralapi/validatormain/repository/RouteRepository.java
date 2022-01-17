package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsRouteIntendedOffer;

import java.util.List;

public interface RouteRepository extends JpaRepository<GtfsRouteIntendedOffer, Long> {
    List<GtfsRouteIntendedOffer> findByFeedId(String id);
    GtfsRouteIntendedOffer findByRouteId(String id);
}
