package sk4j.core;

import java.io.File;

import sk4j.core.model.EProject;

public abstract class MainApp extends SkApp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param args
	 */
	protected void start(String args[]) {
		SkContext.get().putItem("userHome", System.getenv("HOME"));
		SkContext.get().putItem("sk4jHome", format("${userHome}/.sk4j"));
		SkContext.get().putItem("sk4jSDKHome", format("${userHome}/git/sk4j.github.io"));
		if (args.length > 0) {
			SkContext.get().putItem("projectHome", args[0]);
			SkContext.get().setProject(new EProject(new File(args[0])));
		}
		try {
			beforeRun();
			run();
		} catch (Exception e) {
			SkSystem.exit(e.getMessage());
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
