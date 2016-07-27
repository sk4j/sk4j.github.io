package sk4j.api.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import sk4j.impl.model.EJavaPackage;

public interface EProject extends Serializable {

	String getName();

	String getPath();

	File getFile();

	List<EJavaClass> getJavaClasses() throws IOException;

	List<EJavaClass> getSrcMainJavaClasses();

	List<EJavaClass> getSrcMainTestJavaClasses();

	List<EJavaPackage> getSrcMainJavaPackages();

	List<File> getSrcMainWebappDirs();

	List<File> getSrcMainWebappFiles();

	List<File> getDirs() throws IOException;

	List<File> getFiles() throws IOException;

	boolean hasJavaClass(String name) throws IOException;

	public boolean isMavenProject();

}
