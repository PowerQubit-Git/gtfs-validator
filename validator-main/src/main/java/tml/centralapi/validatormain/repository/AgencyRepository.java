package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;

public interface AgencyRepository extends JpaRepository<GtfsAgencyIntendedOffer, Long> {
}
