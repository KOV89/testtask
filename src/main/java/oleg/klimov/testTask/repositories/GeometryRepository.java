package oleg.klimov.testTask.repositories;

import oleg.klimov.testTask.entities.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeometryRepository extends JpaRepository<Geometry,Long> {
}
