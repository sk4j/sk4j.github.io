package sk.sk4j;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.MainApp;
import sk4j.utils.StringTool;

public class SkGeneratorApp extends MainApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private Context ctx;

	@Inject
	private Console console;

	@Inject
	private StringTool st;

	@Inject
	private Template template;

	public static void main(String[] args) throws Exception {
		new SkGeneratorApp().init(args);
	}

	@Override
	protected void beforeRun() throws IOException {
		String projectName = console.readln("Digite o nome do projeto (use o traço como separador): ");
		String projectDesc = console.readln("Digite a descrição do projeto: ");
		validateProjectName(projectName);
		validateProjectDesc(projectDesc);

		ctx.putItem("projectName", projectName);
		ctx.putItem("projectDesc", projectDesc);
	}

	@Override
	public void run() throws URISyntaxException, IOException {
		ctx.putItem("projectDir", ctx.replace("${sk4jSDKHome}/src/${projectName}"));

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

	private void validateProjectName(String projectName) {
		if (st.isEmpty(projectName) || st.containsWhitespace(projectName)) {
			console.exit("O nome do projeto não ser vazio ou conter espaços.");
		}
	}

	private void validateProjectDesc(String projectDesc) {
		if (st.isEmpty(projectDesc)) {
			console.exit("Descrição do projeto inválida.");
		}
	}
}
