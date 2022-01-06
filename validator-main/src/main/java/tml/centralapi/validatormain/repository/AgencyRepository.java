package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.UploadHistoric;

public interface AgencyRepository extends JpaRepository<GtfsAgencyIntendedOffer, Long> {
}
