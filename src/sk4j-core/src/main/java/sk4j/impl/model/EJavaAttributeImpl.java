package sk4j.impl.model;

import java.util.Arrays;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.api.model.EJavaAttribute;

/**
 * 
 * Classe que representa um atributo de uma classe java.
 * 
 * @author jcruz
 *
 */
public class EJavaAttributeImpl implements EJavaAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7454896544844888494L;

	private String name;

	private JavaField qdoxJavaField;

	public EJavaAttributeImpl(JavaField qdoxJavaField) {
		super();
		this.qdoxJavaField = qdoxJavaField;
		this.name = this.qdoxJavaField.getName();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public JavaField getQdoxJavaField() {
		return qdoxJavaField;
	}

	public void setQdoxJavaField(JavaField qdoxJavaField) {
		this.qdoxJavaField = qdoxJavaField;
	}

	/**
	 * Verifica se o atributo possui a annotation especificada.
	 * 
	 * @param name
	 *            Nome da annotation.
	 * @return
	 */
	//@formatter:off
	@Override
	public boolean hasAnnotation(String name) {
		return Arrays.asList(this.qdoxJavaField.getAnnotations())
					.stream()
					.anyMatch(p -> p.getType().getValue().endsWith(name));
	}
	//@formatter:on

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
