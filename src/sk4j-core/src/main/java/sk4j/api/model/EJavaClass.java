package sk4j.api.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;

public interface EJavaClass extends Choosable<EJavaClass>, Serializable {

	String getName();

	String getFullyQualifiedName();

	String getSourceFolderName();

	String getPath();

	String getPackageName();

	EJavaPackage getJavaPackage();

	String getParentPackageName();

	JavaClass getQdoxJavaClass();

	List<EJavaAttribute> getJavaAttributes();

	List<EJavaMethod> getJavaMethods();

	String getSuperClassGenericNameByIndex(int index);

	boolean hasSuperClassGenericNameByNameAndIndex(String genericTypeName, int index);

	boolean hasAnnotationByName(String annotationName);

	boolean extendsSuperClassByName(String superClassName);

	boolean implementsInterfaceByName(String interfaceName);

	boolean isAbstract();

	@Override
	default int compareTo(EJavaClass javaClass) {
		return getName().compareTo(javaClass.getName());
	}

	@Override
	default String getChoiseLabel() {
		return this.getName() + " - " + ConsoleColor.gray(this.getQdoxJavaClass().getPackageName());
	}

}
