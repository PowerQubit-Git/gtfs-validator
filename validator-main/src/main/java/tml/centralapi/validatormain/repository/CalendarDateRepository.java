package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.CalendarDate;

import java.util.List;

public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {
    List<CalendarDate> findByFeedId(String id);
    CalendarDate findByServiceId(String id);
}
