package sk.sk4j;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.AfterStart;
import sk4j.utils.StringTool;

public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private StringTool st;

	@Inject
	private Template template;

	public void run(@Observes AfterStart event) {

		fs.mkdir("{{PROJECT_DIR}}");
		fs.mkdir("{{PROJECT_DIR}}/src/main/java");
		fs.mkdir("{{PROJECT_DIR}}/src/main/java/sk4j");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/templates");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/files");
		fs.mkdir("{{PROJECT_DIR}}/src/main/resources/META-INF");
		fs.mkdir("{{PROJECT_DIR}}/bin");
		fs.mkdir("{{PROJECT_DIR}}/build");

		fs.copy("/files/gitignore", "{{PROJECT_DIR}}/.gitignore");
		fs.copy("/files/readme.txt", "{{PROJECT_DIR}}/src/main/resources/templates/readme.txt");
		fs.copy("/files/readme.txt", "{{PROJECT_DIR}}/src/main/resources/files/readme.txt");
		fs.copy("/files/beans.xml", "{{PROJECT_DIR}}/src/main/resources/META-INF/beans.xml");
		fs.createFile("{{PROJECT_DIR}}", "build.gradle", template.merge("build-gradle"));
		fs.createFile("{{PROJECT_DIR}}/src/main/java/sk4j", st.camelize("{{PROJECT_NAME}}.java"), template.merge("app"));
		fs.createFile("{{PROJECT_DIR}}/src/main/resources", "description.txt", template.merge("description-txt"));

	}

}
