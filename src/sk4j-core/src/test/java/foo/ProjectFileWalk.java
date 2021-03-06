package foo;

import java.io.File;
import java.io.IOException;

import sk4j.implementation.EJavaProjectImpl;

public class ProjectFileWalk {

	public static void main(String[] args) throws IOException {
		EJavaProjectImpl project = new EJavaProjectImpl(new File("/opt/workspace-luna/aelis2016"));
		project.getEFiles().stream().map(p -> p.getFile().getName()).forEach(System.out::println);
	}

}
