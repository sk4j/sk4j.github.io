package sk4j.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaPackage;

import sk4j.input.Selectable;

public interface EJavaPackage extends Selectable<EJavaPackage>, Serializable {

	String getPackageName();

	String getSourceFolderName();

	JavaPackage getQdoxJavaPackage();

	String getPathName();

	EJavaProject getEJavaProject();

	@Override
	default int compareTo(EJavaPackage o) {
		return getPackageName().compareTo(o.getPackageName());
	}

	@Override
	default String getConsoleLabel() {
		return getPackageName();
	}

}
