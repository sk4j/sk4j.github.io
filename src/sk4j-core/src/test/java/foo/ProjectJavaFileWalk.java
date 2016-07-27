package foo;

import java.io.File;
import java.io.IOException;

import sk4j.impl.model.EProjectImpl;

public class ProjectJavaFileWalk {

	public static void main(String[] args) throws IOException {
		EProjectImpl project = new EProjectImpl(new File("/opt/workspace-luna/aelis2016"));
		project.getJavaClasses()
			   .stream()
			   .map(p -> p.getName())
			   .forEach(System.out::println);
	}

}
