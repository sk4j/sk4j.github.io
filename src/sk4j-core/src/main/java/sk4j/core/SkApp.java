package sk4j.core;

import java.io.File;

import sk4j.core.model.EProject;

public abstract class SkApp {

	/**
	 * 
	 * @param args
	 */
	protected void start(String args[]) {
		SkContext.get().putItem("userHome", System.getenv("HOME"));
		SkContext.get().putItem("sk4jHome", String.format("%s/.sk4j", SkContext.get().getItem("userHome")));
		SkContext.get().putItem("projectHome", args[0]);
		SkContext.get().setProject(new EProject(new File(args[0])));

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
	protected void beforeRun() {

	}

	/**
	 * 
	 * @param condition
	 * @param messageOnFail
	 */
	protected void quit(boolean condition, String messageOnFail) {
		if (condition) {
			SkSystem.exit(messageOnFail);
		}
	}

	/**
	 * 
	 */
	protected abstract void run() throws Exception;
}
