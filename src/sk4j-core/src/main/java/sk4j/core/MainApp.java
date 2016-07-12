package sk4j.core;

import java.io.File;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.model.EProject;

public abstract class MainApp extends App {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	/**
	 * 
	 * @param args
	 */
	protected void start(String args[]) {
		context.putItem("userHome", System.getenv("HOME"));
		context.putItem("sk4jHome", format("${userHome}/.sk4j"));
		context.putItem("sk4jSDKHome", format("${userHome}/git/sk4j.github.io"));
		if (args.length > 0) {
			context.putItem("projectHome", args[0]);
			context.setProject(new EProject(new File(args[0])));
		}
		try {
			beforeRun();
			run();
		} catch (Exception e) {
			console.exit(e.getMessage());
		}
	}

	/**
	 * Método chamado antes da execução do método {@link #run()}
	 */
	protected void beforeRun() throws Exception {

	}

	/**
	 * 
	 */
	protected abstract void run() throws Exception;
}
