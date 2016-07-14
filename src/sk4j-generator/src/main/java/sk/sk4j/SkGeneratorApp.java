package sk.sk4j;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.AfterStart;
import sk4j.utils.StringTool;

public class SkGeneratorApp implements Serializable {

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

		fs.mkdir("${projectDir}");
		fs.mkdir("${projectDir}/src/main/java");
		fs.mkdir("${projectDir}/src/main/java/sk4j");
		fs.mkdir("${projectDir}/src/main/resources/templates");
		fs.mkdir("${projectDir}/src/main/resources/files");
		fs.mkdir("${projectDir}/src/main/resources/META-INF");
		fs.mkdir("${projectDir}/bin");
		fs.mkdir("${projectDir}/build");

		fs.copy("/files/gitignore", "${projectDir}/.gitignore");
		fs.copy("/files/readme.txt", "${projectDir}/src/main/resources/templates/readme.txt");
		fs.copy("/files/readme.txt", "${projectDir}/src/main/resources/files/readme.txt");
		fs.copy("/files/beans.xml", "${projectDir}/src/main/resources/META-INF/beans.xml");
		fs.createFile("${projectDir}", "build.gradle", template.merge("build-gradle"));
		fs.createFile("${projectDir}/src/main/java/sk4j", st.camelize("${projectName}.java"), template.merge("app"));
		fs.createFile("${projectDir}/src/main/resources", "description.txt", template.merge("description-txt"));

	}

}
