package dev.tronxi.minimal2dgameengineapi.engine.api.rest.controller;

import dev.tronxi.minimal2dgameengineapi.engine.model.Project;
import dev.tronxi.minimal2dgameengineapi.engine.usecases.CreateProjectUseCase;
import dev.tronxi.minimal2dgameengineapi.engine.usecases.RetrieveProjectsUseCase;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project/")
public class ProjectController {

  private final CreateProjectUseCase createProjectUseCase;
  private final RetrieveProjectsUseCase retrieveProjectsUseCase;

  public ProjectController(CreateProjectUseCase createProjectUseCase,
      RetrieveProjectsUseCase retrieveProjectsUseCase) {
    this.createProjectUseCase = createProjectUseCase;
    this.retrieveProjectsUseCase = retrieveProjectsUseCase;
  }

  @PostMapping("/{projectName}")
  public ResponseEntity<Void> createProject(@PathVariable String projectName) {
    Project project = new Project(projectName);
    createProjectUseCase.create(project);
    return ResponseEntity.ok().build();
  }

  @GetMapping()
  public ResponseEntity<List<Project>> getProjects() {
    return ResponseEntity.ok(retrieveProjectsUseCase.retrieve());
  }

}
