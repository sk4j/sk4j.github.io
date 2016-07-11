package sk4j.core;

import java.io.File;

import org.apache.commons.lang3.text.StrSubstitutor;

import sk4j.core.model.EProject;

public abstract class SkApp {

	/**
	 * 
	 * @param args
	 */
	protected void start(String args[]) {
		SkContext.get().putItem("userHome", System.getenv("HOME"));
		SkContext.get().putItem("sk4jHome", format("${userHome}/.sk4j"));
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

	protected String format(String value) {
		StrSubstitutor substitutor = new StrSubstitutor(SkContext.get().getContext());
		return substitutor.replace(value);
	}

	/**
	 * Método chamado antes da execução do método {@link #run()}
	 */
	protected void beforeRun() throws Exception {

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
