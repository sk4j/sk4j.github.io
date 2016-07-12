package sk4j.core.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.core.input.Choosable;

/**
 * Classe que representa uma classe java.
 * 
 * @author jcruz
 *
 */
public class EJavaFile implements Serializable, Choosable<EJavaFile> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String path;

	private String parentPackageName;

	private JavaClass javaClass;

	private List<EJavaAttribute> javaAttributes;

	private List<EJavaMethod> javaMethods;

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

	//@formatter:off
	public List<EJavaAttribute> getJavaAttributes() {
		if (this.javaAttributes == null) {
			this.javaAttributes = Arrays.asList(javaClass.getFields())
										.stream()
										.map(p -> new EJavaAttribute(p))
										.collect(Collectors.toList());
		}
		return javaAttributes;
	}
	//@formatter:on

	public void setJavaAttributes(List<EJavaAttribute> javaAttributes) {
		this.javaAttributes = javaAttributes;
	}

	//@formatter:off
	public List<EJavaMethod> getJavaMethods() {
		if (this.javaMethods == null) {
			this.javaMethods = Arrays.asList(javaClass.getMethods())
									 .stream()
									 .map(p -> new EJavaMethod(p))
									 .collect(Collectors.toList());
		}
		return javaMethods;
	}
	//@formatter:on

	public void setJavaMethods(List<EJavaMethod> javaMethods) {
		this.javaMethods = javaMethods;
	}

	/**
	 * Verifica se a classe possui a annotation especificada.
	 * 
	 * @param name
	 *            Nome da annotation.
	 * @return
	 */
	//@formatter:off
	public boolean hasAnnotation(String name) {
		return Arrays.asList(javaClass.getAnnotations())
					.stream()
					.anyMatch(p -> p.getType().getValue().endsWith(name));
	}
	//@formatter:on

	@Override
	public int compareTo(EJavaFile o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public String getChoiseLabel() {
		return this.getName();
	}

}