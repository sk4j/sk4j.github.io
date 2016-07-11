package sk.sk4j;

import java.io.IOException;

import org.jboss.forge.roaster.model.util.Strings;

import sk4j.core.SkApp;
import sk4j.core.SkContext;
import sk4j.core.console.SkConsole;

public class App extends SkApp {

	public static void main(String[] args) {
		new App().start(args);
	}

	@Override
	protected void beforeRun() throws IOException {
		String projectName = SkConsole.readln("Digite o nome do projeto");
		String projectDesc = SkConsole.readln("Digite a descrição do projeto");

		quit(Strings.isBlank(projectName), "Nome de projeto inválido.");
		quit(Strings.isBlank(projectDesc), "Descrição do projeto inválida.");

		SkContext.get().putItem("projectName", projectName);
		SkContext.get().putItem("projectDesc", projectDesc);
	}

	@Override
	public void run() {
		String projectDir = format("${sk3jHome}/src/${projectName}");
	}
}
