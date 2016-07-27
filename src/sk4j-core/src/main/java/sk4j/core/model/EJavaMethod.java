package sk4j.core.model;

import java.io.Serializable;
import java.util.Arrays;

import com.thoughtworks.qdox.model.JavaMethod;

import sk4j.core.console.Choosable;

/**
 * Classe que representa um método de uma classe java.
 * 
 * @author jcruz
 *
 */
public class EJavaMethod implements Serializable, Choosable<EJavaMethod> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private JavaMethod qdoxJavaMethod;

	public EJavaMethod(JavaMethod qdoxJavaMethod) {
		super();
		this.qdoxJavaMethod = qdoxJavaMethod;
		this.name = this.qdoxJavaMethod.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JavaMethod getQdoxJavaMethod() {
		return qdoxJavaMethod;
	}

	public void setQdoxJavaMethod(JavaMethod qdoxJavaMethod) {
		this.qdoxJavaMethod = qdoxJavaMethod;
	}

	//@formatter:off
	public boolean hasAnnotation(String name) {
		return Arrays.asList(this.qdoxJavaMethod.getAnnotations())
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
		EJavaMethod other = (EJavaMethod) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EJavaMethod [name=" + name + "]";
	}

	@Override
	public int compareTo(EJavaMethod o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public String getChoiseLabel() {
		return this.name;
	}

}
