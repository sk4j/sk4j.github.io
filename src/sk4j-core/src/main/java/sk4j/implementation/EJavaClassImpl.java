package sk4j.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.qdox.model.JavaClass;

import sk4j.model.EJavaAttribute;
import sk4j.model.EJavaClass;
import sk4j.model.EJavaMethod;
import sk4j.model.EJavaPackage;
import sk4j.model.EJavaProject;

public class EJavaClassImpl implements EJavaClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EJavaProject project;

	private String name;

	private String fullyQualifiedName;

	private String sourceFolderName;

	private String path;

	private String packageName;

	private String parentPackageName;

	private JavaClass qdoxJavaClass;

	private List<EJavaAttribute> javaAttributes;

	private List<EJavaMethod> javaMethods;

	public EJavaClassImpl(EJavaProject project, String sourceFolder, JavaClass qdoxJavaClass) {
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
	public boolean hasAnnotationByName(String name) {
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

	@Override
	public String getSuperClassGenericNameByIndex(int index) {
		if (index <= qdoxJavaClass.getSuperClass().getActualTypeArguments().length) {
			return qdoxJavaClass.getSuperClass().getActualTypeArguments()[index].getValue();
		}
		return "";
	}

	@Override
	public boolean hasSuperClassGenericNameByNameAndIndex(String genericTypeName, int index) {
		return getSuperClassGenericNameByIndex(index).endsWith(genericTypeName);
	}

	@Override
	public boolean isAbstract() {
		return this.qdoxJavaClass.isAbstract();
	}

	@Override
	public boolean extendsSuperClassByName(String name) {
		return this.qdoxJavaClass.getSuperClass().getValue().endsWith(name);
	}

	@Override
	public boolean implementsInterfaceByName(String name) {
		//@formatter:off
		return Arrays.asList(this.qdoxJavaClass.getImplementedInterfaces())
			.stream()
			.anyMatch(javaClass -> javaClass.getName().endsWith(name));
		//@formatter:on
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getFullyQualifiedName() == null) ? 0 : getFullyQualifiedName().hashCode());
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
		EJavaClassImpl other = (EJavaClassImpl) obj;
		if (getFullyQualifiedName() == null) {
			if (other.getFullyQualifiedName() != null)
				return false;
		} else if (!getFullyQualifiedName().equals(other.getFullyQualifiedName()))
			return false;
		return true;
	}

}