package sk.sk4j.bootstrap;

import javax.enterprise.event.Observes;

import sk4j.core.BootstrapApp;
import sk4j.event.BeforeStart;

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
