package foo;

import java.io.File;

import sk4j.api.model.EProject;
import sk4j.impl.model.EProjectImpl;

public class EProjectTest {

	public static void main(String[] args) {
		EProject project = new EProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getSrcMainJavaClasses()
			.stream()
			.forEach(javaClass -> System.out.println(javaClass.getName()));
		//@formatter:on
	}

}
