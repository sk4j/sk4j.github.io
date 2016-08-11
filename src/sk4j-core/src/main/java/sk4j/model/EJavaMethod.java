package sk4j.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

import sk4j.input.Selectable;

public interface EJavaMethod extends Selectable<EJavaMethod>, Serializable {

	String getMethodName();

	JavaMethod getQdoxJavaMethod();

	boolean hasAnnotationByName(String annotationName);

	EJavaProject getEJavaProject();

	@Override
	default int compareTo(EJavaMethod o) {
		return getMethodName().compareTo(o.getMethodName());
	}

	@Override
	default String getConsoleLabel() {
		return getMethodName();
	}

}
