package sk4j.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaPackage;

import sk4j.input.Selectable;

public interface EJavaPackage extends Selectable<EJavaPackage>, Serializable {

	String getName();

	String getSourceFolderName();

	JavaPackage getQdoxJavaPackage();

	String getPath();

	EJavaProject getProject();

	@Override
	default int compareTo(EJavaPackage o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getSelectLabel() {
		return getName();
	}

}
