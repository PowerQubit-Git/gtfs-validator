package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsCalendarIntendedOffer;

public interface CalendarRepository  extends JpaRepository<GtfsCalendarIntendedOffer, Long> {
}
