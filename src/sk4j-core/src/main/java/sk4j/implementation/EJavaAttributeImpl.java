package sk4j.implementation;

import java.util.Arrays;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.model.EJavaAttribute;
import sk4j.model.EJavaProject;

public class EJavaAttributeImpl implements EJavaAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7454896544844888494L;

	private EJavaProject project;

	private String name;

	private JavaField qdoxJavaField;

	public EJavaAttributeImpl(EJavaProject project, JavaField qdoxJavaField) {
		super();
		this.project = project;
		this.qdoxJavaField = qdoxJavaField;
	}

	@Override
	public String getName() {
		return this.qdoxJavaField.getName();
	}

	@Override
	public JavaField getQdoxJavaField() {
		return qdoxJavaField;
	}

	//@formatter:off
	@Override
	public boolean hasAnnotationByName(String name) {
		return Arrays.asList(this.qdoxJavaField.getAnnotations())
					.stream()
					.anyMatch(p -> p.getType().getValue().endsWith(name));
	}
	//@formatter:on

	@Override
	public boolean isLongPrimitive() {
		return this.qdoxJavaField.getType().getValue().equals("long");
	}

	@Override
	public boolean isIntegerPrimitive() {
		return this.qdoxJavaField.getType().getValue().equals("int");
	}

	@Override
	public boolean isBigDecimal() {
		return this.qdoxJavaField.getType().getValue().endsWith("BigDecimal");
	}

	@Override
	public boolean isDate() {
		return this.qdoxJavaField.getType().getValue().endsWith("Date");
	}

	@Override
	public boolean isBooleanPrimitive() {
		return this.qdoxJavaField.getType().getValue().equals("boolean");
	}

	@Override
	public boolean isLongWrapper() {
		return this.qdoxJavaField.getType().getValue().endsWith("Long");
	}

	@Override
	public boolean isIntegerWrapper() {
		return this.qdoxJavaField.getType().getValue().endsWith("Integer");
	}

	@Override
	public boolean isBooleanWrapper() {
		return this.qdoxJavaField.getType().getValue().endsWith("Boolean");
	}

	@Override
	public boolean isString() {
		return this.qdoxJavaField.getType().getValue().endsWith("String");
	}

	@Override
	public boolean isList() {
		return this.qdoxJavaField.getType().getValue().endsWith("List");
	}

	@Override
	public boolean isMap() {
		return this.qdoxJavaField.getType().getValue().endsWith("Map");
	}

	@Override
	public boolean isSet() {
		return this.qdoxJavaField.getType().getValue().endsWith("Set");
	}

	@Override
	public boolean isEnum() {
		if (qdoxJavaField.getType().getJavaClass() != null) {
			if (qdoxJavaField.getType().getJavaClass().getSuperClass() != null) {
				return qdoxJavaField.getType().getJavaClass().getSuperClass().getFullyQualifiedName().endsWith("Enum");
			}
		}
		return false;
	}

	@Override
	public boolean isStatic() {
		return this.qdoxJavaField.isStatic();
	}

	@Override
	public boolean isPrivate() {
		return this.qdoxJavaField.isPrivate();
	}

	@Override
	public boolean isPublic() {
		return this.qdoxJavaField.isPublic();
	}

	@Override
	public boolean isProtected() {
		return this.qdoxJavaField.isProtected();
	}

	@Override
	public boolean hasGenericNameByNameAndIndex(String genericTypeName, int index) {
		if (qdoxJavaField.getType().getActualTypeArguments().length > 0) {
			if (index <= qdoxJavaField.getType().getActualTypeArguments().length) {
				return qdoxJavaField.getType().getActualTypeArguments()[index].getValue().endsWith(genericTypeName);
			}
		}
		return false;
	}

	@Override
	public String getGenericNameByIndex(int index) {
		if (index <= qdoxJavaField.getType().getActualTypeArguments().length) {
			return qdoxJavaField.getType().getActualTypeArguments()[index].getValue();
		}
		return "";
	}

	public EJavaProject getProject() {
		return project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EJavaAttributeImpl other = (EJavaAttributeImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EJavaAttribute [name=" + name + "]";
	}

}
