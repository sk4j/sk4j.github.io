package sk4j.core.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	String name;
	/**
	 * 
	 */
	String path;

	/**
	 * 
	 */
	File file;

	/**
	 * 
	 */
	List<EJavaFile> javaFiles;

	/**
	 * 
	 */
	List<File> dirs;

	/**
	 * 
	 */
	List<File> files;

	/**
	 * 
	 */
	List<EXmlFile> xmlFiles;

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

	public List<EJavaFile> getJavaFiles() {
		if(javaFiles == null) {
			javaFiles = new ArrayList<>();
		}
		return javaFiles;
	}

	public void setJavaFiles(List<EJavaFile> javaFiles) {
		this.javaFiles = javaFiles;
	}

	public List<File> getDirs() {
		return dirs;
	}

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}

	public List<File> getFiles() {
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

}
