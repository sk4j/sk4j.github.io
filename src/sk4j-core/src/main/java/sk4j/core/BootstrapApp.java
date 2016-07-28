package sk4j.core;

import java.io.File;
import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.impl.model.EJavaProjectImpl;

public abstract class BootstrapApp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	@Inject
	private Event<AfterStart> afterStartEvent;

	@Inject
	private Event<BeforeStart> beforeStartEvent;

	protected void init(String args[]) {
		try {
			Weld weld = new Weld();
			WeldContainer container = weld.initialize();
			BootstrapApp mainApp = container.instance().select(BootstrapApp.class).get();
			mainApp.start(args);
			weld.shutdown();
		} catch (Exception e) {
			//console.exit(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	private void start(String args[]) throws Exception {
		setupContext(args);
		fireBeforeStartEvent();
		fireAfterInitEvent();
	}

	private void fireBeforeStartEvent() {
		beforeStartEvent.fire(new BeforeStart() {
			private static final long serialVersionUID = 1L;
		});
	}

	private void setupContext(String[] args) {
		context.putItem("USER_HOME", System.getenv("HOME"));
		context.putItem("SK4J_HOME", context.replace("{{USER_HOME}}/git/sk4j.github.io"));
		context.putItem("PROJECT_HOME", args[0]);
		context.setProject(new EJavaProjectImpl(new File(args[0])));
	}

	private void fireAfterInitEvent() {
		afterStartEvent.fire(new AfterStart() {
			private static final long serialVersionUID = 1L;
		});
	}

}
