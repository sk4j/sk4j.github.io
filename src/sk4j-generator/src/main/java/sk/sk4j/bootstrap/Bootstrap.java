package sk.sk4j.bootstrap;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.BeforeStart;
import sk4j.core.BootstrapApp;
import sk4j.utils.StringTool;

public class Bootstrap extends BootstrapApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context ctx;

	@Inject
	private Console console;

	@Inject
	private StringTool st;

	public static void main(String[] args) {
		new Bootstrap().init(args);
	}

	protected void validate(@Observes BeforeStart event) {
		String projectName = console.readln("Digite o nome do projeto (use o traço como separador): ");
		String projectDesc = console.readln("Digite a descrição do projeto: ");
		console.exitIf(st.isEmpty(projectName) || st.containsWhitespace(projectName), "O nome do projeto não ser vazio ou conter espaços.");
		console.exitIf(st.isEmpty(projectDesc), "Descrição do projeto inválida.");

		ctx.putItem("PROJECT_NAME", projectName);
		ctx.putItem("PROJECT_DESC", projectDesc);
		ctx.putItem("PROJECT_DIR", ctx.replace("{{SK4J_HOME}}/src/{{PROJECT_NAME}}"));
	}

}
