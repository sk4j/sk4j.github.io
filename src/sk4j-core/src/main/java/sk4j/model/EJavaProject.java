package sk4j.model;

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
	String getProjectName();

	/**
	 * Retorna o caminho do projeto.
	 * 
	 * @return Caminho do projeto.
	 */
	String getPathName();

	File getProjectFile();

	List<EJavaClass> getAllEJavaClasses() throws IOException;

	List<EJavaClass> getMainEJavaClasses();

	List<EJavaPackage> getMainEJavaPackages();

	List<EJavaPackage> getTestEJavaPackages();

	List<EJavaClass> getTestEJavaClasses();

	List<EPath> getWebappEPaths() throws IOException;

	List<EFile> getWebappEFiles() throws IOException;

	List<EFile> getWebappXHTMLFiles() throws IOException;

	List<EPath> getEPaths() throws IOException;

	List<EFile> getEFiles() throws IOException;

	boolean hasMainEJavaClassByName(String javaClassName) throws IOException;

	public boolean isMavenProject();

	public boolean isGradleProject();

}
