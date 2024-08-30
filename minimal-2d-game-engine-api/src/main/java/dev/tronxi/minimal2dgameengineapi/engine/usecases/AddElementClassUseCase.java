package dev.tronxi.minimal2dgameengineapi.engine.usecases;

import dev.tronxi.minimal2dgameengineapi.engine.model.ElementClass;
import dev.tronxi.minimal2dgameengineapi.engine.model.Project;
import dev.tronxi.minimal2dgameengineapi.engine.usecases.services.ProjectFileRetriever;
import dev.tronxi.minimal2dgameengineapi.engine.usecases.services.PropertiesManager;
import java.io.File;
import java.nio.file.Path;
import org.springframework.stereotype.Service;

@Service
public class AddElementClassUseCase extends AddResourceUseCase {


  public AddElementClassUseCase(ProjectFileRetriever projectFileRetriever,
      PropertiesManager propertiesManager) {
    super(projectFileRetriever, propertiesManager);
  }

  public void add(Project project, ElementClass elementClass) {
    File projectFile = projectFileRetriever.retrieveProjectFile(workspace, project);
    Path elementClassesPath = projectFile.toPath().resolve("elementClasses");

    createResourcesPath(elementClassesPath);
    createResourceFile(elementClassesPath, elementClass.className());
    writeResourceContent(elementClassesPath, elementClass.className(), elementClass.representation());
    propertiesManager.addElementClass(project, elementClass);
  }

}
