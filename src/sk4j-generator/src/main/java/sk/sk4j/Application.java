package sk.sk4j;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk.sk4j.name.ProjectDesc;
import sk.sk4j.name.ProjectName;
import sk4j.core.Context;
import sk4j.event.AfterStart;
import sk4j.file.EPaths;
import sk4j.file.FS;
import sk4j.input.Reader;
import sk4j.template.Template;

public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private Template template;

	@Inject
	private Context ctx;

	@Inject
	private Reader reader;

	@Inject
	private ProjectName projectName;

	@Inject
	private ProjectDesc projectDesc;

	public void run(@Observes AfterStart event) throws IOException {

		reader.read("Digite o nome do projeto", "projectName", projectName);
		reader.read("Digite a descrição do projeto", "projectDesc", projectDesc);
		ctx.put("PROJECT_DIR", ctx.replace("{{SK4J_HOME}}/src/{{projectName.value}}"));

		fs.mkdir(EPaths.get("{{PROJECT_DIR}}"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/java"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/java/sk4j"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/java/sk4j/bootstrap"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/resources/templates"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/resources/files"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/src/main/resources/META-INF"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/bin"));
		fs.mkdir(EPaths.get("{{PROJECT_DIR}}/build"));

		fs.copy("/files/gitignore", EPaths.get("{{PROJECT_DIR}}/.gitignore"));
		fs.copy("/files/readme-txt", EPaths.get("{{PROJECT_DIR}}/src/main/resources/templates/readme.txt"));
		fs.copy("/files/readme-txt", EPaths.get("{{PROJECT_DIR}}/src/main/resources/files/readme.txt"));
		fs.copy("/files/bootstrap-java", EPaths.get("{{PROJECT_DIR}}/src/main/java/sk4j/bootstrap/Bootstrap.java"));
		fs.copy("/files/application-java", EPaths.get("{{PROJECT_DIR}}/src/main/java/sk4j/Application.java"));
		fs.copy("/files/beans-xml", EPaths.get("{{PROJECT_DIR}}/src/main/resources/META-INF/beans.xml"));

		template.mergeAndCreateFile("build-gradle", EPaths.get("{{PROJECT_DIR}}/build.gradle"));
		template.mergeAndCreateFile("description-txt", EPaths.get("{{PROJECT_DIR}}/src/main/resources/description.txt"));
		// fs.createFile("{{PROJECT_DIR}}", "build.gradle", template.merge("/templates/build-gradle.jtwig"));
		// fs.createFile("{{PROJECT_DIR}}/src/main/resources", "description.txt", template.merge("/templates/description-txt.jtwig"));

	}

}
