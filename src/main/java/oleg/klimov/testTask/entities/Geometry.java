package oleg.klimov.testTask.entities;

import javax.persistence.*;

@Entity
@Table(name = "geometries")
public class Geometry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Project project;

    public Geometry() {}

    public Geometry(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
