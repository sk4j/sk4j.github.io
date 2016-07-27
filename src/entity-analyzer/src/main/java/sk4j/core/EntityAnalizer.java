package sk4j.core;

import java.io.Serializable;

import sk4j.api.model.EJavaClass;

public interface EntityAnalizer extends Serializable {
	void analyze(EJavaClass javaFile);
}
