package sk4j.producer;

import java.io.File;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import sk4j.core.SystemContext;
import sk4j.impl.EJavaProjectImpl;
import sk4j.model.EJavaProject;

public class EJavaProjectProducer {

	@Inject
	private SystemContext context;

	@Produces
	@Singleton
	public EJavaProject javaProject() {
		File projectFile = new File((String) context.get("PROJECT_HOME"));
		return new EJavaProjectImpl(projectFile);
	}

}
