package sk4j.core.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaSource;

public class EProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String path;

	/**
	 * 
	 */
	private File file;

	/**
	 * 
	 */
	private List<EJavaFile> javaFiles;

	/**
	 * 
	 */
	private List<File> dirs;

	/**
	 * 
	 */
	private List<File> files;

	/**
	 * 
	 */
	private List<EXmlFile> xmlFiles;

	public EProject(File file) {
		super();
		this.file = file;
	}

	public String getName() {
		return name;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<EJavaFile> getJavaFiles() throws IOException {
		if (javaFiles == null) {
			//@formatter:off
			this.javaFiles = Files.walk(file.toPath())
								  .filter(p -> p.toFile().getName().endsWith(".java"))
								  .map(this::createJavaFile)
								  .filter(Objects::nonNull)
								  .collect(Collectors.toList());
			//@formatter:on
		}
		return javaFiles;
	}

	public void setJavaFiles(List<EJavaFile> javaFiles) {
		this.javaFiles = javaFiles;
	}

	public List<File> getDirs() throws IOException {
		if (this.dirs == null) {
			//@formatter:off
			this.dirs = Files.walk(file.toPath())
							 .filter(p -> p.toFile().isDirectory() && !p.toFile().isHidden())
							 .map(p -> p.toFile())
							 .collect(Collectors.toList());
			//@formatter:on
		}
		return dirs;
	}

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}

	public List<File> getFiles() throws IOException {
		if (this.files == null) {
			//@formatter:off
			this.files = Files.walk(file.toPath())
							  .filter(p -> p.toFile().isFile() && !p.toFile().isHidden())
							  .map(p -> p.toFile())
							  .collect(Collectors.toList());
			//@formatter:on
		}
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<EXmlFile> getXmlFiles() {
		return xmlFiles;
	}

	public void setXmlFiles(List<EXmlFile> xmlFiles) {
		this.xmlFiles = xmlFiles;
	}

	public boolean hasJavaFile(String name) throws IOException {
		//@formatter:off
		return getFiles()
			.stream()
			.filter(p -> p.getName().equals(name.concat(".java")))
			.count() > 0;
		//@formatter:onf
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		EProject other = (EProject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	private EJavaFile createJavaFile(Path path) {
		try {
			JavaDocBuilder builder = new JavaDocBuilder();
			JavaSource source = builder.addSource(path.toFile());
			String pathFile = FilenameUtils.normalize(FilenameUtils.getFullPath(path.toFile().getAbsolutePath()));
			return new EJavaFile(pathFile, source.getClasses()[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
