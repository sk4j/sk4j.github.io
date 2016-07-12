package sk4j.core.model;

import java.io.Serializable;
import java.util.Arrays;

import com.thoughtworks.qdox.model.JavaField;

import sk4j.core.input.Choosable;

/**
 * 
 * Classe que representa um atributo de uma classe java.
 * 
 * @author jcruz
 *
 */
public class EJavaAttribute implements Serializable, Choosable<EJavaAttribute> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private JavaField javaField;

	public EJavaAttribute(JavaField javaField) {
		super();
		this.javaField = javaField;
		this.name = this.javaField.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JavaField getJavaField() {
		return javaField;
	}

	public void setJavaField(JavaField javaField) {
		this.javaField = javaField;
	}

	/**
	 * Verifica se o atributo possui a annotation especificada.
	 * 
	 * @param name Nome da annotation.
	 * @return
	 */
	//@formatter:off
	public boolean hasAnnotation(String name) {
		return Arrays.asList(this.javaField.getAnnotations())
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
		EJavaAttribute other = (EJavaAttribute) obj;
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

	@Override
	public int compareTo(EJavaAttribute o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public String getChoiseLabel() {
		return this.name;
	}

}
