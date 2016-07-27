package sk4j.api.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.core.console.Choosable;

public interface EJavaAttribute extends Choosable<EJavaAttribute>, Serializable {
	String getName();

	JavaField getQdoxJavaField();

	boolean hasAnnotation(String name);

	@Override
	default int compareTo(EJavaAttribute o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getChoiseLabel() {
		return getName();
	}

}
