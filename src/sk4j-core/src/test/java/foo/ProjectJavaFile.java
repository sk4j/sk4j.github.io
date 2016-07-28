package foo;

import java.io.File;
import java.io.IOException;

import sk4j.impl.model.EProjectImpl;

public class ProjectJavaFile {

	public static void main(String[] args) throws IOException {
		EProjectImpl project = new EProjectImpl(new File("/opt/workspace-luna/aelis2016"));
		System.out.println(project.hasSrcMainJavaClass("TipoPontoBC1"));
	}

}
