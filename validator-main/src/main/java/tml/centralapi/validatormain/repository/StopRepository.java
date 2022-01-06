package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;

public interface StopRepository  extends JpaRepository<GtfsStopIntendedOffer, Long> {
}
