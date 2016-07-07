package sk4j.core.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.JavaClass;

/**
 * Classe que representa uma classe java.
 * 
 * @author jcruz
 *
 */
public class EJavaFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String path;

	private String parentPackageName;

	private JavaClass javaClass;

	private List<EJavaAttribute> attributes;

	private List<EJavaMethod> methods;

	public EJavaFile(String path, JavaClass javaClass) {
		super();
		this.path = path;
		this.javaClass = javaClass;
	}

	public String getName() {
		if (this.name == null) {
			this.name = this.javaClass.getName();
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParentPackageName() {
		return parentPackageName;
	}

	public void setParentPackageName(String parentPackageName) {
		this.parentPackageName = parentPackageName;
	}

	public JavaClass getJavaClass() {
		return javaClass;
	}

	public void setJavaClass(JavaClass javaClass) {
		this.javaClass = javaClass;
	}

	public List<EJavaAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<EJavaAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<EJavaMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<EJavaMethod> methods) {
		this.methods = methods;
	}

}
