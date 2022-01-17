package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsAgencyIntendedOffer;
import tml.centralapi.validatormain.model.GtfsCalendarIntendedOffer;

import java.util.List;

public interface CalendarRepository  extends JpaRepository<GtfsCalendarIntendedOffer, Long> {
    List<GtfsCalendarIntendedOffer> findByFeedId(String id);
    GtfsCalendarIntendedOffer findByCalendarId(String id);
}
