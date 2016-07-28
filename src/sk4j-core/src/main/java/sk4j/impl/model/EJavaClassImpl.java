package sk4j.impl.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.api.model.EJavaAttribute;
import sk4j.api.model.EJavaClass;
import sk4j.api.model.EJavaMethod;
import sk4j.api.model.EJavaPackage;
import sk4j.api.model.EProject;

public class EJavaClassImpl implements EJavaClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EProject project;

	private String name;

	private String fullyQualifiedName;

	private String sourceFolderName;

	private String path;

	private String packageName;

	private String parentPackageName;

	private JavaClass qdoxJavaClass;

	private List<EJavaAttribute> javaAttributes;

	private List<EJavaMethod> javaMethods;

	public EJavaClassImpl(EProject project, String sourceFolder, JavaClass qdoxJavaClass) {
		super();
		this.project = project;
		this.sourceFolderName = sourceFolder;
		this.qdoxJavaClass = qdoxJavaClass;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = this.qdoxJavaClass.getName();
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getFullyQualifiedName() {
		if (this.fullyQualifiedName == null) {
			this.fullyQualifiedName = this.qdoxJavaClass.getFullyQualifiedName();
		}
		return fullyQualifiedName;
	}

	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	@Override
	public String getPath() {
		if (this.path == null) {
			String packageDir = this.qdoxJavaClass.getPackage().getName().replaceAll("\\.", "/");
			this.path = FilenameUtils.normalize(project.getPath().concat(this.sourceFolderName).concat("/").concat(packageDir));
		}
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String getPackageName() {
		if (this.packageName == null) {
			this.packageName = this.qdoxJavaClass.getPackageName();
		}
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String getParentPackageName() {
		if (this.parentPackageName == null) {
			List<String> packageTokens = Arrays.asList(getQdoxJavaClass().getPackageName().split("\\."));
			this.parentPackageName = StringUtils.join(packageTokens.subList(0, packageTokens.size() - 1), ".");
		}
		return parentPackageName;
	}

	public void setParentPackageName(String parentPackageName) {
		this.parentPackageName = parentPackageName;
	}

	@Override
	public JavaClass getQdoxJavaClass() {
		return qdoxJavaClass;
	}

	public void setQdoxJavaClass(JavaClass qdoxJavaClass) {
		this.qdoxJavaClass = qdoxJavaClass;
	}

	//@formatter:off
	@Override
	public List<EJavaAttribute> getJavaAttributes() {
		if (this.javaAttributes == null) {
			this.javaAttributes = Arrays.asList(qdoxJavaClass.getFields())
										.stream()
										.map(javaField -> new EJavaAttributeImpl(project,javaField))
										.collect(Collectors.toList());
		}
		return javaAttributes;
	}
	//@formatter:on

	public void setJavaAttributes(List<EJavaAttribute> javaAttributes) {
		this.javaAttributes = javaAttributes;
	}

	//@formatter:off
	@Override
	public List<EJavaMethod> getJavaMethods() {
		if (this.javaMethods == null) {
			this.javaMethods = Arrays.asList(qdoxJavaClass.getMethods())
									 .stream()
									 .map(javaMethod -> new EJavaMethodImpl(project,javaMethod))
									 .collect(Collectors.toList());
		}
		return javaMethods;
	}
	//@formatter:on

	public void setJavaMethods(List<EJavaMethod> javaMethods) {
		this.javaMethods = javaMethods;
	}

	@Override
	public EJavaPackage getJavaPackage() {
		return null;
	}

	/**
	 * Verifica se a classe possui a annotation especificada.
	 * 
	 * @param name
	 *            Nome da annotation.
	 * @return
	 */
	//@formatter:off
	@Override
	public boolean hasAnnotation(String name) {
		return Arrays.asList(qdoxJavaClass.getAnnotations())
					.stream()
					.anyMatch(p -> p.getType().getValue().endsWith(name));
	}
	//@formatter:on

	@Override
	public String toString() {
		return "EJavaFile [fullyQualifiedName=" + getFullyQualifiedName() + "]";
	}

	@Override
	public String getSourceFolderName() {
		return this.sourceFolderName;
	}

}
