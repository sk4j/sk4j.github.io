package foo;

import java.io.File;
import java.io.IOException;

import sk4j.implementation.EJavaProjectImpl;

public class ProjectJavaFile {

	public static void main(String[] args) throws IOException {
		EJavaProjectImpl project = new EJavaProjectImpl(new File("/opt/workspace-luna/aelis2016"));
		System.out.println(project.hasMainEJavaClassByName("TipoPontoBC1"));
	}

}
