package sk.sk4j;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.AppValidator;
import sk4j.core.BeforeStart;
import sk4j.utils.StringTool;

public class SkGeneratorAppValidator implements AppValidator {

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

	public void validate(@Observes BeforeStart event) {
		String projectName = console.readln("Digite o nome do projeto (use o traço como separador): ");
		String projectDesc = console.readln("Digite a descrição do projeto: ");
		validateProjectName(projectName);
		validateProjectDesc(projectDesc);

		ctx.putItem("projectName", projectName);
		ctx.putItem("projectDesc", projectDesc);
		ctx.putItem("projectDir", ctx.replace("${sk4jSDKHome}/src/${projectName}"));
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
