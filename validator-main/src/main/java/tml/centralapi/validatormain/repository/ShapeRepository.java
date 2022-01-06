package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.GtfsShapeIntendedOffer;

public interface ShapeRepository extends JpaRepository<GtfsShapeIntendedOffer, Long> {
}
