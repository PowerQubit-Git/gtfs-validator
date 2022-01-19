package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.CalendarDates;

import java.util.List;

public interface CalendarDateRepository extends JpaRepository<CalendarDates, Long> {
    List<CalendarDates> findByFeedId(String id);
    CalendarDates findByServiceId(String id);
}
