package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tml.centralapi.validatormain.model.GtfsStopIntendedOffer;
import tml.centralapi.validatormain.model.SpGetTripsByLine;

import java.util.List;
import java.util.stream.Stream;

public interface SpGetTripsByLineRepository  extends JpaRepository<GtfsStopIntendedOffer, Long> {
    @Procedure(procedureName = "sp_number_of_trips_by_lines")
    Stream<SpGetTripsByLine> getSpNumberOfTripsByLine();
}