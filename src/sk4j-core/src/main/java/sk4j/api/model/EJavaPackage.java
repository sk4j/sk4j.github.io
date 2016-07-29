package sk4j.api.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaPackage;

import sk4j.console.Choosable;

public interface EJavaPackage extends Choosable<EJavaPackage>, Serializable {

	String getName();

	String getSourceFolderName();

	JavaPackage getQdoxJavaPackage();

	String getPath();

	@Override
	default int compareTo(EJavaPackage o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getChoiseLabel() {
		return getName();
	}

}
