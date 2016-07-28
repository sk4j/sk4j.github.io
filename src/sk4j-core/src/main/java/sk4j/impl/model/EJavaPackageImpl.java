package sk4j.impl.model;

import org.apache.commons.io.FilenameUtils;

import com.thoughtworks.qdox.model.JavaPackage;

import sk4j.api.model.EJavaPackage;
import sk4j.api.model.EProject;

public class EJavaPackageImpl implements EJavaPackage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EProject project;

	private String name;

	private String sourceFolderName;

	private JavaPackage qdoxJavaPackage;

	private String path;

	public EJavaPackageImpl(EProject project, JavaPackage qdoxJavaPackage, String sourceFolderName) {
		super();
		this.project = project;
		this.qdoxJavaPackage = qdoxJavaPackage;
		this.sourceFolderName = sourceFolderName;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = this.qdoxJavaPackage.getName();
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSourceFolderName() {
		return this.sourceFolderName;
	}

	public void setSourceFolderName(String sourceFolderName) {
		this.sourceFolderName = sourceFolderName;
	}

	@Override
	public JavaPackage getQdoxJavaPackage() {
		return this.qdoxJavaPackage;
	}

	public void setQdoxJavaPackage(JavaPackage qdoxJavaPackage) {
		this.qdoxJavaPackage = qdoxJavaPackage;
	}

	@Override
	public String getPath() {
		if (this.path == null) {
			String packageDir = this.qdoxJavaPackage.getName().replaceAll("\\.", "/");
			this.path = FilenameUtils.normalize(project.getPath().concat(this.sourceFolderName).concat("/").concat(packageDir));
		}
		return this.path;
	}

}
