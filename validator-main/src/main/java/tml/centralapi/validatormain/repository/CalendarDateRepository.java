package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsCalendarDateIntendedOffer;

public interface CalendarDateRepository extends JpaRepository<GtfsCalendarDateIntendedOffer, Long> {}
