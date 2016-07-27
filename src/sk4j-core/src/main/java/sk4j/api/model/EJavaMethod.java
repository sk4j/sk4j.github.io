package sk4j.api.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

import sk4j.core.console.Choosable;

public interface EJavaMethod extends Choosable<EJavaMethod>, Serializable {

	String getName();

	JavaMethod getQdoxJavaMethod();

	@Override
	default int compareTo(EJavaMethod o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getChoiseLabel() {
		return getName();
	}

}
