package sk4j.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

import com.thoughtworks.qdox.JavaDocBuilder;

import sk4j.model.EFile;
import sk4j.model.EJavaClass;
import sk4j.model.EJavaPackage;
import sk4j.model.EJavaProject;

public class EJavaProjectImpl implements EJavaProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private File file;

	private List<EJavaClass> javaClasses;

	private List<EJavaClass> srcMainJavaClasses;

	private List<EJavaClass> srcTestJavaClasses;

	private List<EJavaPackage> srcMainJavaPackages;

	private List<EJavaPackage> srcTestJavaPackages;

	private List<EFile> srcMainWebappDirs;

	private List<EFile> srcMainWebappFiles;

	private List<EFile> dirs;

	private List<EFile> files;

	private List<EFile> srcMainWebappXHTMLFiles;

	public EJavaProjectImpl(File file) {
		super();
		this.file = file;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = FilenameUtils.getBaseName(getPath());
		}
		return name;
	}

	@Override
	public String getPath() {
		return file.getAbsolutePath();
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public List<EJavaClass> getJavaClasses() throws IOException {
		if (javaClasses == null) {
			this.javaClasses = new ArrayList<>();
			this.javaClasses.addAll(getSrcMainJavaClasses());
			this.javaClasses.addAll(getSrcTestJavaClasses());
		}
		return javaClasses;
	}

	//@formatter:off
	@Override
	public List<EFile> getDirs() throws IOException {
		if (this.dirs == null) {
			this.dirs = Files.walk(file.toPath())
							 .filter(p -> p.toFile().isDirectory() && !p.toFile().isHidden())
							 .map(p -> new EFileImpl(p.toFile()))
							 .collect(Collectors.toList());
		}
		return dirs;
	}
	//@formatter:on

	@Override
	public List<EFile> getFiles() throws IOException {
		if (this.files == null) {
			//@formatter:off
			this.files = Files.walk(file.toPath())
							  .filter(p -> p.toFile().isFile() && !p.toFile().isHidden())
							  .map(p -> new EFileImpl(p.toFile()))
							  .collect(Collectors.toList());
			//@formatter:on
		}
		return files;
	}

	public void setFiles(List<EFile> files) {
		this.files = files;
	}

	@Override
	public boolean hasSrcMainJavaClassByName(String name) throws IOException {
		//@formatter:off
		return getSrcMainJavaClasses()
			.stream()
			.anyMatch(javaClass -> javaClass.getName().equals(name));
		//@formatter:on
	}

	@Override
	public boolean isMavenProject() {
		return new File(String.format("%s/pom.xml", getPath())).exists();
	}

	@Override
	public boolean isGradleProject() {
		return new File(String.format("%s/build.gradle", getPath())).exists();
	}

	@Override
	public List<EJavaClass> getSrcMainJavaClasses() {
		if (this.srcMainJavaClasses == null) {
			//@formatter:off
			this.srcMainJavaClasses = getSrcMainJavaPackages()
							.stream()
							.map(javaPackage -> javaPackage.getQdoxJavaPackage().getClasses())
							.flatMap(qdoxJavaClasses -> Arrays.asList(qdoxJavaClasses).stream())
							.map(qdoxJavaClass -> new EJavaClassImpl(this, "/src/main/java/", qdoxJavaClass))
							.filter(javaClass -> !javaClass.getQdoxJavaClass().isInterface() && !javaClass.getQdoxJavaClass().isEnum())
							.collect(Collectors.toList());
			//@formatter:on
		}
		return srcMainJavaClasses;
	}

	@Override
	public List<EJavaClass> getSrcTestJavaClasses() {
		if (this.srcTestJavaClasses == null) {
			//@formatter:off
			this.srcTestJavaClasses = getSrcTestJavaPackages()
							.stream()
							.map(javaPackage -> javaPackage.getQdoxJavaPackage().getClasses())
							.flatMap(qdoxJavaClasses -> Arrays.asList(qdoxJavaClasses).stream())
							.map(qdoxJavaClass -> new EJavaClassImpl(this, "/src/test/java/", qdoxJavaClass))
							.filter(javaClass -> !javaClass.getQdoxJavaClass().isInterface() && !javaClass.getQdoxJavaClass().isEnum())
							.collect(Collectors.toList());
			//@formatter:on
		}
		return srcTestJavaClasses;
	}

	@Override
	public List<EJavaPackage> getSrcMainJavaPackages() {
		if (this.srcMainJavaPackages == null) {
			JavaDocBuilder builder = new JavaDocBuilder();
			File srcMainJavaDir = new File(FilenameUtils.normalize(getPath().concat("/src/main/java/")));
			builder.addSourceTree(srcMainJavaDir);

			//@formatter:off
			this.srcMainJavaPackages = Arrays.asList(builder.getPackages())
					.stream()
					.map(javaPackage -> new EJavaPackageImpl(this, javaPackage , "/src/main/java/"))
					.collect(Collectors.toList());
			//@formatter:on
		}
		return this.srcMainJavaPackages;
	}

	@Override
	public List<EFile> getSrcMainWebappDirs() throws IOException {
		if (this.srcMainWebappDirs == null) {
			//@formatter:off
			this.srcMainWebappDirs= Files.walk(file.toPath())
					 				.filter(path -> path.toFile().isDirectory() && !path.toFile().isHidden())
					 				.filter(dir -> dir.toFile().getAbsolutePath().contains("/src/main/webapp/"))
					 				.map(path -> new EFileImpl(path.toFile()))
					 				.collect(Collectors.toList());
			//@formatter:on
		}
		return srcMainWebappDirs;
	}

	@Override
	public List<EFile> getSrcMainWebappFiles() throws IOException {
		if (this.srcMainWebappFiles == null) {
			//@formatter:off
			this.srcMainWebappFiles = Files.walk(file.toPath())
					 				.filter(path -> path.toFile().isFile() && !path.toFile().isHidden())
					 				.filter(file -> file.toFile().getAbsolutePath().contains("/src/main/webapp/"))
					 				.map(path -> new EFileImpl(path.toFile()))
					 				.collect(Collectors.toList());
			//@formatter:on
		}
		return srcMainWebappFiles;
	}

	@Override
	public List<EJavaPackage> getSrcTestJavaPackages() {
		if (this.srcTestJavaPackages == null) {
			JavaDocBuilder builder = new JavaDocBuilder();
			File srcTestJavaDir = new File(FilenameUtils.normalize(getPath().concat("/src/test/java/")));
			builder.addSourceTree(srcTestJavaDir);

			//@formatter:off
			this.srcTestJavaPackages = Arrays.asList(builder.getPackages())
										.stream()
										.map(javaPackage -> new EJavaPackageImpl(this, javaPackage , "/src/test/java/"))
										.collect(Collectors.toList());
			//@formatter:on
		}
		return this.srcTestJavaPackages;
	}

	@Override
	public List<EFile> getSrcMainWebappXHTMLFiles() throws IOException {
		if (this.srcMainWebappXHTMLFiles == null) {
			//@formatter:off
			this.srcMainWebappXHTMLFiles = getSrcMainWebappFiles()
												.stream()
												.filter(file -> file.getFile().getName().endsWith(".xhtml"))
												.collect(Collectors.toList());
			//@formatter:on
		}
		return srcMainWebappXHTMLFiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
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
		EJavaProjectImpl other = (EJavaProjectImpl) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
