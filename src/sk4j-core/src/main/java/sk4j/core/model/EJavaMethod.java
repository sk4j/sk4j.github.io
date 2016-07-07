package sk4j.core.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

public class EJavaMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private JavaMethod javaMethod;

	public EJavaMethod(JavaMethod javaMethod) {
		super();
		this.javaMethod = javaMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JavaMethod getJavaMethod() {
		return javaMethod;
	}

	public void setJavaMethod(JavaMethod javaMethod) {
		this.javaMethod = javaMethod;
	}

	@Override
	public String toString() {
		return "EJavaMethod [name=" + name + "]";
	}

}
