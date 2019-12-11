package oleg.klimov.testTask.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import oleg.klimov.testTask.entities.Attribute;
import oleg.klimov.testTask.entities.Geometry;
import oleg.klimov.testTask.entities.Project;
import oleg.klimov.testTask.entities.Views;
import oleg.klimov.testTask.repositories.AttributeRepository;
import oleg.klimov.testTask.repositories.GeometryRepository;
import oleg.klimov.testTask.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final AttributeRepository attributeRepository;
    private final GeometryRepository geometryRepository;
    private final ProjectRepository projectRepository;

    public MainController(AttributeRepository attributeRepository, GeometryRepository geometryRepository, ProjectRepository projectRepository) {
        this.attributeRepository = attributeRepository;
        this.geometryRepository = geometryRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/api/projects")
    @JsonView(Views.Project.class)
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/api/projects/{id}")
    @JsonView(Views.Project.class)
    public Project getProjectById(@PathVariable(name = "id") Long id) {
        return projectRepository.getOne(id);
    }

    @PostMapping("/api/projects")
    public void createProject(Project project) {
        projectRepository.save(project);
        for (int i=0; i<10000; i++) {
            geometryRepository.save(new Geometry("Geom"+i, project));
            attributeRepository.save(new Attribute("Attr"+i, project));
        }
    }

    @PutMapping("/api/projects/{id}")
    public void updateNameProject(@PathVariable(name = "id") Project project,
                                  @RequestBody String name) {
        project.setName(name);
        projectRepository.save(project);
    }

    @DeleteMapping("/api/projects/{id}")
    public void deleteProject(@PathVariable(name = "id") Long id) {
        projectRepository.deleteById(id);
    }
}
