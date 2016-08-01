package foo;

import java.io.File;

import sk4j.impl.EJavaProjectImpl;
import sk4j.model.EJavaProject;

public class EProjectTest {

	public static void main(String[] args) {
		EJavaProject project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getSrcMainJavaClasses()
			.stream()
			.forEach(javaClass -> System.out.println(javaClass.getName()));
		//@formatter:on
	}

}
