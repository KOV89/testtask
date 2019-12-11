package oleg.klimov.testTask.repositories;

import oleg.klimov.testTask.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute,Long> {
}
