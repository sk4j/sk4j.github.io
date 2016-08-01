package sk4j.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

import sk4j.console.Selectable;

public interface EJavaMethod extends Selectable<EJavaMethod>, Serializable {

	String getName();

	JavaMethod getQdoxJavaMethod();

	boolean hasAnnotationByName(String annotationName);

	@Override
	default int compareTo(EJavaMethod o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getSelectLabel() {
		return getName();
	}

}
