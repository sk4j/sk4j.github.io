package foo;

import java.io.File;
import java.io.IOException;

import sk4j.core.model.EProject;

public class ProjectFileWalk {

	public static void main(String[] args) throws IOException {
		EProject project = new EProject(new File("/opt/workspace-luna/aelis2016"));
		project.getFiles()
			   .stream()
			   .map(p -> p.getName())
			   .forEach(System.out::println);
	}

}
