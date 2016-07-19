package sk4j.core;

import java.io.Serializable;

import sk4j.core.model.EJavaFile;

public interface EntityAnalizer extends Serializable {
	void analyze(EJavaFile javaFile);
}
