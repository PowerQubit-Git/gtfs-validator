package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsCalendarDateIntendedOffer;
import tml.centralapi.validatormain.model.GtfsFeedInfoIntendedOffer;

import java.util.List;

public interface CalendarDateRepository extends JpaRepository<GtfsCalendarDateIntendedOffer, Long> {
    List<GtfsCalendarDateIntendedOffer> findByFeedId(String id);
    GtfsCalendarDateIntendedOffer findByServiceId(String id);
}
