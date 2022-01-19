package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.Trip;

import java.util.List;

public interface TripRepository  extends JpaRepository<Trip, Long> {
    List<Trip> findByFeedId(String id);
    Trip findByTripId(String id);
}
