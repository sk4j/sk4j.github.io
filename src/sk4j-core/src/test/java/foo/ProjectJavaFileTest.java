package foo;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.implementation.EJavaProjectImpl;

@RunWith(SK4JRunner.class)
public class ProjectJavaFileTest {

	@Test
	public void main() throws IOException {
		EJavaProjectImpl project = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/aelis2016"));
		// System.out.println(project.getAllEJavaClasses().size());
		//@formatter:off
		project.getAllEJavaClasses()
			.stream()
			.map(p -> p.getClassName())
			.forEach(System.out::println);
		//@formatter:on
	}

}
