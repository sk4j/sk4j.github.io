package sk4j.core.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaField;

public class EJavaAttribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private JavaField javaField;

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

	@Override
	public String toString() {
		return "EJavaAttribute [name=" + name + "]";
	}

}
