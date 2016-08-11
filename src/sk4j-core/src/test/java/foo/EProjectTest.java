package foo;

import java.io.File;

import sk4j.implementation.EJavaProjectImpl;
import sk4j.model.EJavaProject;

public class EProjectTest {

	public static void main(String[] args) {
		EJavaProject project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getMainEJavaClasses()
			.stream()
			.forEach(javaClass -> System.out.println(javaClass.getClassName()));
		//@formatter:on
	}

}
