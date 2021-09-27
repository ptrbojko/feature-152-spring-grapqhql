package demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ProjectController {

    public ProjectController() {
        System.out.println("dupa");
    }

    @MutationMapping
    public Project createProjectWithWorkingInput(@Argument WorkingProjectInput newProject) {
        Project project = new Project(UUID.randomUUID().toString());
        project.setName(newProject.getName());
        project.setRepositoryUrl(newProject.getRepositoryUrl());
        return project;
    }

    @MutationMapping
    public Project createProjectWithBadInput(@Argument BadProjectInput newProject) {
        // this will not work because BadProjectInput does not have setters
        Project project = new Project(UUID.randomUUID().toString());
        project.setName(newProject.getName());
        project.setRepositoryUrl(newProject.getRepositoryUrl());
        return project;
    }

    @QueryMapping
    public Project project(@Argument String slug) {
        System.out.println("aaaa");
        Project project = new Project(slug);
        project.setName("Some name");
        project.setRepositoryUrl("Some url");
        return project;
    }
}
