package sk4j.api.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;

public interface EJavaClass extends Choosable<EJavaClass>, Serializable {

	String getName();

	String getFullyQualifiedName();

	String getPath();

	String getPackageName();

	String getParentPackageName();

	JavaClass getQdoxJavaClass();

	List<EJavaAttribute> getJavaAttributes();

	List<EJavaMethod> getJavaMethods();

	boolean hasAnnotation(String name);

	@Override
	default int compareTo(EJavaClass javaClass) {
		return getName().compareTo(javaClass.getName());
	}

	@Override
	default String getChoiseLabel() {
		return this.getName() + " - " + ConsoleColor.gray(this.getQdoxJavaClass().getPackageName());
	}

}
