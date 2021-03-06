package foo;

import java.io.File;
import java.io.IOException;

import sk4j.implementation.EJavaProjectImpl;

public class ProjectDirWalk {

	public static void main(String[] args) throws IOException {
		EJavaProjectImpl project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		project.getEPaths().stream().map(p -> p.getPath().toFile()).forEach(System.out::println);
	}

}
