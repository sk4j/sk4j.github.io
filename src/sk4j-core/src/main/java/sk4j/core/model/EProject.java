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

/**
 * 
 * Classe que representa um Prejeto Java (Maven ou Gradle).
 * 
 * @author jcruz
 *
 */
public class EProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String path;

	private File file;

	private List<EJavaFile> javaFiles;

	private List<File> dirs;

	private List<File> files;

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
		return file.getAbsolutePath();
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

	/**
	 * Retorna a lista de todos os arquivos .java do projeto.
	 * 
	 * @return Lista de arquivos java
	 * @throws IOException
	 */
	//@formatter:off
	public List<EJavaFile> getJavaFiles() throws IOException {
		if (javaFiles == null) {
			this.javaFiles = Files.walk(file.toPath())
								  .filter(p -> p.toFile().getName().endsWith(".java"))
								  .map(this::createJavaFile)
								  .filter(Objects::nonNull)
								  .collect(Collectors.toList());
		}
		return javaFiles;
	}
	//@formatter:on

	public void setJavaFiles(List<EJavaFile> javaFiles) {
		this.javaFiles = javaFiles;
	}

	/**
	 * Retorna todos os diretórios não ocultos do projeto.
	 * 
	 * @return Lista de todos os diretórios do projeto.
	 * @throws IOException
	 */
	//@formatter:off
	public List<File> getDirs() throws IOException {
		if (this.dirs == null) {
			this.dirs = Files.walk(file.toPath())
							 .filter(p -> p.toFile().isDirectory() && !p.toFile().isHidden())
							 .map(p -> p.toFile())
							 .collect(Collectors.toList());
		}
		return dirs;
	}
	//@formatter:on

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}

	/**
	 * Retorna a lista de todos os arquivos do projeto.
	 * 
	 * @return Lista de todos os arquivos do projeto.
	 * @throws IOException
	 */
	//@formatter:off
	public List<File> getFiles() throws IOException {
		if (this.files == null) {
			this.files = Files.walk(file.toPath())
							  .filter(p -> p.toFile().isFile() && !p.toFile().isHidden())
							  .map(p -> p.toFile())
							  .collect(Collectors.toList());
		}
		return files;
	}
	//@formatter:on

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<EXmlFile> getXmlFiles() {
		return xmlFiles;
	}

	public void setXmlFiles(List<EXmlFile> xmlFiles) {
		this.xmlFiles = xmlFiles;
	}

	/**
	 * 
	 * Verifica se o projeto possui o arquivo java especificado.
	 * 
	 * @param name
	 *            Nome do arquivo.
	 * @return
	 * @throws IOException
	 */
	//@formatter:off
	public boolean hasJavaFile(String name) throws IOException {
		return getFiles()
			.stream()
			.anyMatch(p -> p.getName().equals(name.concat(".java")));
	}
	//@formatter:onf

	/**
	 * Verifica se o projeto é um projeto Maven.
	 * 
	 * @return
	 */
	public boolean isMavenProject() {
		return new File("${path}/pom.xml").exists();
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

	/*
	 * 
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