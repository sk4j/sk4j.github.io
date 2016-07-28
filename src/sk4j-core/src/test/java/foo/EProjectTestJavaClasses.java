package foo;

import java.io.File;
import java.util.Arrays;

import sk4j.api.model.EJavaProject;
import sk4j.impl.model.EJavaProjectImpl;

public class EProjectTestJavaClasses {

	public static void main(String[] args) {
		EJavaProject project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/ouvidoriaweb"));
		//@formatter:off
		project.getSrcMainJavaPackages()
			.stream()
			.forEach(javaPackage -> {
				System.out.println(javaPackage.getName());
				//System.out.println(javaPackage.getPath());
				Arrays.asList(javaPackage.getQdoxJavaPackage().getClasses())
					.stream().forEach(javaClass -> System.out.println(javaClass.getName()));
				System.out.println("\n");
			});
		//@formatter:on
	}

}
