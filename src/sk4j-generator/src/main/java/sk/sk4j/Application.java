package sk.sk4j;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.console.reader.ReadConf;
import sk4j.event.AfterStart;

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
	private Console console;

	public void run(@Observes AfterStart event) {

		String projectName = console.read("Digite o nome do projeto", ReadConf.SK_PROJECT_NAME);
		String projectDesc = console.read("Digite a descrição do projeto", ReadConf.ALPHANUMERIC_SPACE);

		ctx.putItem("PROJECT_NAME", projectName);
		ctx.putItem("PROJECT_DESC", projectDesc);
		ctx.putItem("PROJECT_DIR", ctx.replace("{{SK4J_HOME}}/src/{{PROJECT_NAME}}"));

		fs.mkdir("{{PROJECT_DIR}}");
		fs.mkdir("{{PROJECT_DIR}}/src/main/java");
		fs.mkdir("{{PROJECT_DIR}}/src/main/java/sk4j");
		fs.mkdir("{{PROJECT_DIR}}/src/main/java/sk4j/bootstrap");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/templates");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/files");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/META-INF");
		fs.mkdir("{{PROJECT_DIR}}/bin");
		fs.mkdir("{{PROJECT_DIR}}/build");

		fs.copy("/files/gitignore", "{{PROJECT_DIR}}/.gitignore");
		fs.copy("/files/readme-txt", "{{PROJECT_DIR}}/src/main/resources/templates/readme.txt");
		fs.copy("/files/readme-txt", "{{PROJECT_DIR}}/src/main/resources/files/readme.txt");
		fs.copy("/files/bootstrap-java", "{{PROJECT_DIR}}/src/main/java/sk4j/bootstrap/Bootstrap.java");
		fs.copy("/files/application-java", "{{PROJECT_DIR}}/src/main/java/sk4j/Application.java");
		fs.copy("/files/beans-xml", "{{PROJECT_DIR}}/src/main/resources/META-INF/beans.xml");

		fs.createFile("{{PROJECT_DIR}}", "build.gradle", template.merge("/templates/build-gradle.jtwig"));
		fs.createFile("{{PROJECT_DIR}}/src/main/resources", "description.txt", template.merge("/templates/description-txt.jtwig"));

	}

}
