package sk.sk4j;

import java.io.File;
import java.io.IOException;

import org.jboss.forge.roaster.model.util.Strings;

import sk4j.core.SkApp;
import sk4j.core.SkContext;
import sk4j.core.Skfs;
import sk4j.core.console.SkConsole;

public class App extends SkApp {

	public static void main(String[] args) {
		new App().start(args);
	}

	@Override
	protected void beforeRun() throws IOException {

		quit(!hasSDK(), "É necessário clonar o projeto sk4j do github: https://github.com/sk4j/sk4j.github.io.git");

		String projectName = SkConsole.readln("Digite o nome do projeto: ");
		String projectDesc = SkConsole.readln("Digite a descrição do projeto: ");

		quit(Strings.isBlank(projectName), "Nome de projeto inválido.");
		quit(Strings.isBlank(projectDesc), "Descrição do projeto inválida.");

		SkContext.get().putItem("projectName", projectName);
		SkContext.get().putItem("projectDesc", projectDesc);
	}

	@Override
	public void run() {
		String projectDir = format("${sk4jSdkHome}/src/${projectName}");
		SkContext.get().putItem("projectDir", projectDir);

		Skfs.mkdir("${projectDir}");
		Skfs.mkdir("${projectDir}/src/main/java");
		Skfs.mkdir("${projectDir}/src/main/java/sk4j");
		Skfs.mkdir("${projectDir}/src/resources/templates");
		Skfs.mkdir("${projectDir}/bin");
		Skfs.mkdir("${projectDir}/build");

	}

	/**
	 * 
	 * Verifica se o diretório
	 * 
	 * @return
	 */
	private boolean hasSDK() {
		return new File(String.valueOf(SkContext.get().getItem("sk4jSDKHome"))).exists();
	}
}
