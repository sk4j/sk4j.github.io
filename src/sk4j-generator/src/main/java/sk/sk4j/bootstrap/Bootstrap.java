package sk.sk4j.bootstrap;

import javax.enterprise.event.Observes;

import sk4j.core.BeforeStart;
import sk4j.core.BootstrapApp;

public class Bootstrap extends BootstrapApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Bootstrap().init(args);
	}

	protected void validate(@Observes BeforeStart event) {

	}

}
