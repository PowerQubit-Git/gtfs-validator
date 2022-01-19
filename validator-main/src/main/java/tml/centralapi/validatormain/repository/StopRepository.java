package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.Stop;

import java.util.List;

public interface StopRepository  extends JpaRepository<Stop, Long> {
    List<Stop> findByFeedId(String id);
    Stop findByStopId(String id);
}
