package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsRouteIntendedOffer;

public interface RouteRepository extends JpaRepository<GtfsRouteIntendedOffer, Long> {
}
