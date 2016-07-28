package sk4j.api.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface EProject extends Serializable {

	String getName();

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

	boolean hasSrcMainJavaClass(String name) throws IOException;

	public boolean isMavenProject();

}
