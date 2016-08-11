package foo;

import java.io.File;
import java.io.IOException;

import sk4j.implementation.EJavaProjectImpl;
import sk4j.model.EJavaProject;

public class EProjectTestWebAppDirs {

	public static void main(String[] args) throws IOException {
		EJavaProject project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getWebappEFiles()
			.stream()
			.forEach(dir -> System.out.println(dir.getFile().getName()));
			
		//@formatter:on
	}

}
