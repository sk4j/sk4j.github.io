package sk4j.core;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import jline.console.UserInterruptException;
import sk4j.annotation.RequiredJavaProject;
import sk4j.console.Colorize;
import sk4j.event.AfterStart;
import sk4j.event.BeforeStart;
import sk4j.exception.RequiredJavaProjectException;
import sk4j.model.EJavaProject;

public abstract class BootstrapApp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private EJavaProject project;

	@Inject
	private Event<AfterStart> afterStartEvent;

	@Inject
	private Event<BeforeStart> beforeStartEvent;

	protected void init(String args[]) {
		Weld weld = new Weld();
		try {
			WeldContainer container = weld.initialize();
			Beans.setBeanManager(container.getBeanManager());
			BootstrapApp mainApp = container.instance().select(BootstrapApp.class).get();
			mainApp.start(args);
		} catch (UserInterruptException e) {
			System.out.println("");
			System.out.println(Colorize.cyan("Bye sk4j"));
			System.out.println("");
		} catch (RequiredJavaProjectException e) {
			System.out.println("");
			System.out.println(Colorize.red(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			weld.shutdown();
		}
	}

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	private void start(String args[]) throws Exception {
		setupContext(args);
		checkRequiredJavaProject();
		fireBeforeStartEvent();
		fireAfterInitEvent();
	}

	private void fireBeforeStartEvent() {
		beforeStartEvent.fire(new BeforeStart() {
			private static final long serialVersionUID = 1L;
		});
	}

	private void setupContext(String[] args) {
		context.put("USER_HOME", System.getenv("HOME"));
		context.put("SK4J_HOME", context.replace("{{USER_HOME}}/git/sk4j.github.io"));
		context.put("PROJECT_HOME", args[0]);
	}

	private void fireAfterInitEvent() {
		afterStartEvent.fire(new AfterStart() {
			private static final long serialVersionUID = 1L;
		});
	}

	private void checkRequiredJavaProject() throws RequiredJavaProjectException {
		if (this.getClass().isAnnotationPresent(RequiredJavaProject.class)) {
			if (!this.project.isMavenProject() || !this.project.isGradleProject()) {
				throw new RequiredJavaProjectException("O diretório não possui projeto maven ou gradle.");
			}
		}
	}

}
