package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsTripIntendedOffer;

public interface TripRepository  extends JpaRepository<GtfsTripIntendedOffer, Long> {
}
