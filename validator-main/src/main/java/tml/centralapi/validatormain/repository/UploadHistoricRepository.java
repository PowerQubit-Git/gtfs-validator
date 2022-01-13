package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tml.centralapi.validatormain.model.UploadHistoric;

@Repository
public interface UploadHistoricRepository extends JpaRepository<UploadHistoric, Long> {
}