package sk4j.producer;

import java.io.File;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import sk4j.core.Context;
import sk4j.implementation.EJavaProjectImpl;
import sk4j.model.EJavaProject;

public class EJavaProjectProducer {

	@Inject
	private Context context;

	@Produces
	@Singleton
	public EJavaProject javaProject() {
		File projectFile = new File((String) context.get("PROJECT_HOME"));
		return new EJavaProjectImpl(projectFile);
	}

}
