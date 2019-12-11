package oleg.klimov.testTask.repositories;

import oleg.klimov.testTask.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
