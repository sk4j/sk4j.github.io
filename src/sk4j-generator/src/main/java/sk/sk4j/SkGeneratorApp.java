package sk.sk4j;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.core.MainApp;

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

	public static void main(String[] args) throws Exception {
		new SkGeneratorApp().init(args);
	}

	@Override
	protected void beforeRun() throws IOException {
		String projectName = console.readln("Digite o nome do projeto: ");
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

	}

	private void validateProjectName(String projectName) {
		if (projectName == null || projectName.isEmpty()) {
			console.exit("Nome do projeto inválido.");
		}
	}

	private void validateProjectDesc(String projectDesc) {
		if (projectDesc == null || projectDesc.isEmpty()) {
			console.exit("Descrição do projeto inválida.");
		}
	}
}
