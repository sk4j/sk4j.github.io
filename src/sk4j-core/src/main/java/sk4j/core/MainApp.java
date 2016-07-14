package sk4j.core;

import java.io.File;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.model.EProject;

public abstract class MainApp implements App {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	protected void init(String args[]) {
		try {
			Weld weld = new Weld();
			WeldContainer container = weld.initialize();
			MainApp mainApp = container.instance().select(MainApp.class).get();
			mainApp.start(args);
			weld.shutdown();
		} catch (Exception e) {
			console.exit(e.getMessage());
		}
	}

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	private void start(String args[]) throws Exception {
		context.putItem("userHome", System.getenv("HOME"));
		context.putItem("sk4jHome", context.replace("${userHome}/.sk4j"));
		context.putItem("sk4jSDKHome", context.replace("${userHome}/git/sk4j.github.io"));
		context.putItem("projectHome", args[0]);
		context.setProject(new EProject(new File(args[0])));
		beforeRun();
		run();

	}

	/**
	 * Método chamado antes da execução do método {@link #run()}
	 */
	protected void beforeRun() throws Exception {

	}

}
