package foo;

import java.io.File;
import java.io.IOException;

import sk4j.core.model.EProject;

public class ProjectDirWalk {

	public static void main(String[] args) throws IOException {
		EProject project = new EProject(new File("/opt/workspace-luna/aelis2016"));
		project.getDirs()
			   .stream()
			   .map(p -> p.getName())
			   .forEach(System.out::println);
	}

}
