package sk4j.api.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * Representação de um projeto java.
 * 
 * @author jcruz
 *
 */
public interface EJavaProject extends Serializable {

	/**
	 * Retorna o nome do projeto.
	 * 
	 * @return Nome do projeto
	 */
	String getName();

	/**
	 * Retorna o caminho do projeto.
	 * 
	 * @return Caminho do projeto.
	 */
	String getPath();

	File getFile();

	List<EJavaClass> getJavaClasses() throws IOException;

	List<EJavaClass> getSrcMainJavaClasses();

	List<EJavaPackage> getSrcMainJavaPackages();

	List<EJavaPackage> getSrcTestJavaPackages();

	List<EJavaClass> getSrcTestJavaClasses();

	List<File> getSrcMainWebappDirs() throws IOException;

	List<File> getSrcMainWebappFiles() throws IOException;

	List<File> getSrcMainWebappXHTMLFiles() throws IOException;

	List<File> getDirs() throws IOException;

	List<File> getFiles() throws IOException;

	boolean hasSrcMainJavaClassByName(String javaClassName) throws IOException;

	public boolean isMavenProject();

	public boolean isGradleProject();

}
