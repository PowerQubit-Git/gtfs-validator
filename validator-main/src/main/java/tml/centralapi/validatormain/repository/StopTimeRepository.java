package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsStopTimeIntendedOffer;

public interface StopTimeRepository extends JpaRepository<GtfsStopTimeIntendedOffer, Long> {
}
