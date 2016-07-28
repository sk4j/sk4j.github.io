package foo;

import java.io.File;
import java.io.IOException;

import sk4j.api.model.EProject;
import sk4j.impl.model.EProjectImpl;

public class EProjectTestWebAppDirs {

	public static void main(String[] args) throws IOException {
		EProject project = new EProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getSrcMainWebappFiles()
			.stream()
			.forEach(dir -> System.out.println(dir.getName()));
			
		//@formatter:on
	}

}
