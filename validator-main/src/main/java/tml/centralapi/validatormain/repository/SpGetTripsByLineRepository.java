package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tml.centralapi.validatormain.model.SpGetTripsByLine;

import java.util.List;

public interface SpGetTripsByLineRepository  extends JpaRepository<SpGetTripsByLine, Long> {
    @Query(name= "sp_number_of_trips_by_lines()", value = "SELECT public.sp_number_of_trips_by_lines();", nativeQuery = true)
    List<SpGetTripsByLine> spNumberOfTripsByLines();

}