package sk4j.bootstrap;

import java.io.IOException;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.BeforeStart;
import sk4j.core.BootstrapApp;

public class Bootstrap extends BootstrapApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	public static void main(String[] args) {
		new Bootstrap().init(args);
	}

	protected void validate(@Observes BeforeStart event) throws IOException {
		if (!context.getProject().isMavenProject()) {
			console.exit("O diretório não contém um projeto maven.");
		}
		if (!context.getProject().getJavaClasses().stream().anyMatch(javaClass -> javaClass.hasAnnotation("Entity"))) {
			console.exit("O projeto não possui nenhuma entidade.");
		}
	}

}
