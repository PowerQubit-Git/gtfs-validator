package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.Calendar;

import java.util.List;

public interface CalendarRepository  extends JpaRepository<Calendar, Long> {
    List<Calendar> findByFeedId(String id);
    Calendar findByServiceId(String id);
}
