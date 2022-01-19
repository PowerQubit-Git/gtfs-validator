package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.CsvRowFeedIdCompositeKey;
import tml.centralapi.validatormain.model.StopTime;

import java.util.List;

public interface StopTimeRepository extends JpaRepository<StopTime, CsvRowFeedIdCompositeKey> {
    List<StopTime> findByFeedId(String id);
}
