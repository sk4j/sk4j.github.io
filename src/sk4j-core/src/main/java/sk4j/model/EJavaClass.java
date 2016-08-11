package sk4j.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.console.Colorize;
import sk4j.input.Selectable;

public interface EJavaClass extends Selectable<EJavaClass>, Serializable {

	String getClassName();

	String getFullyQualifiedName();

	String getSourceFolderName();

	String getPathName();

	String getPackageName();

	EJavaPackage getEJavaPackage();

	String getParentPackageName();

	JavaClass getQdoxJavaClass();

	List<EJavaAttribute> getEJavaAttributes();

	List<EJavaMethod> getEJavaMethods();

	String getSuperClassGenericNameByIndex(int index);

	boolean hasSuperClassGenericNameByNameAndIndex(String genericTypeName, int index);

	boolean hasAnnotationByName(String annotationName);

	boolean extendsSuperClassByName(String superClassName);

	boolean implementsInterfaceByName(String interfaceName);

	boolean isAbstract();

	@Override
	default int compareTo(EJavaClass ejavaClass) {
		return getClassName().compareTo(ejavaClass.getClassName());
	}

	@Override
	default String getConsoleLabel() {
		return this.getClassName() + " - " + Colorize.gray(this.getQdoxJavaClass().getPackageName());
	}

}
