package sk4j.api.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;

public interface EJavaAttribute extends Choosable<EJavaAttribute>, Serializable {
	String getName();

	JavaField getQdoxJavaField();

	boolean isLongPrimitive();

	boolean isLongWrapper();

	boolean isIntegerPrimitive();

	boolean isIntegerWrapper();

	boolean isBigDecimal();

	boolean isDate();

	boolean isBooleanPrimitive();

	boolean isBooleanWrapper();

	boolean isString();

	boolean isList();

	boolean isMap();

	boolean isSet();

	boolean isEnum();

	boolean isStatic();

	boolean isPrivate();

	boolean isPublic();

	boolean isProtected();

	boolean hasAnnotationByName(String annotationName);

	boolean hasGenericNameByNameAndIndex(String genericTypeName, int index);

	String getGenericNameByIndex(int index);

	@Override
	default int compareTo(EJavaAttribute o) {
		return getName().compareTo(o.getName());
	}

	@Override
	default String getChoiseLabel() {
		return this.getName() + " - " + ConsoleColor.gray(this.getQdoxJavaField().getType().getValue());
	}

}
