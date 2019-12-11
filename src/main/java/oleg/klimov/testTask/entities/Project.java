package oleg.klimov.testTask.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Project.class)
    private Long id;

    @Column(unique = true)
    @JsonView(Views.Project.class)
    private String name;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Geometry> geometries;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Attribute> attributes;

    public Project() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Geometry> getGeometries() {
        return geometries;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }
}
