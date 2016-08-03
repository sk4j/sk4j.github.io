package sk4j.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.console.ConsoleSelectable;
import sk4j.console.ConsoleColor;

/**
 * Modelo de atributo java.
 * 
 * @author jcruz
 *
 */
public interface EJavaAttribute extends ConsoleSelectable<EJavaAttribute>, Serializable {

	/**
	 * Retorna o nome do atributo java.
	 * 
	 * @return Nome do atributo java.
	 */
	String getName();

	/**
	 * Retorna objeto qdox do atributo.
	 * 
	 * @return objeto do tipo JavaField qdox.
	 */
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
	default String getSelectLabel() {
		return this.getName() + " - " + ConsoleColor.gray(this.getQdoxJavaField().getType().getValue());
	}

}
