package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.Frequency;

public interface FrequencyRepository extends JpaRepository<Frequency, Long> {
}
