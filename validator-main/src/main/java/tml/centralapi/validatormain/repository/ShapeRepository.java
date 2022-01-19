package tml.centralapi.validatormain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tml.centralapi.validatormain.model.Shape;

import java.util.List;

public interface ShapeRepository extends JpaRepository<Shape, Long> {
    List<Shape> findByFeedId(String id);
    Shape findByShapeId(String id);
}
