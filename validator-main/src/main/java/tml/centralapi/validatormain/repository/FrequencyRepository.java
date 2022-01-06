package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsFrequencyIntendedOffer;

public interface FrequencyRepository extends JpaRepository<GtfsFrequencyIntendedOffer, Long> {
}
