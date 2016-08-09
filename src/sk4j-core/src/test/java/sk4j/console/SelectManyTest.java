package sk4j.console;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.implementation.EJavaProjectImpl;
import sk4j.input.Selector;
import sk4j.model.EJavaClass;
import sk4j.model.EJavaProject;

@RunWith(SK4JRunner.class)
public class SelectManyTest {
	@Inject
	private Selector selector;

	@Test
	public void test() throws IOException {
		EJavaProject javaProject = new EJavaProjectImpl(new File("/home/jcruz/Programs/eclipse-mars/workspace/aelis2016"));
		//@formatter:off
		List<EJavaClass> selectedJavaClass = selector.selectMany(javaProject.getSrcMainJavaClasses()
					.stream()
					.filter(javaClass -> javaClass.hasAnnotationByName("Entity"))
					.collect(Collectors.toList()), "Selecione a(s) entidade(s)");
		//@formatter:off
		System.out.println(selectedJavaClass);
	}
}
