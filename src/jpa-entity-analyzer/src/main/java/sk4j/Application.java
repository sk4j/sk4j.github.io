package sk4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.stream.Collectors;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import sk4j.annotation.Analyzer;
import sk4j.core.Task;
import sk4j.event.AfterStart;
import sk4j.input.Selector;
import sk4j.model.EJavaProject;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@Analyzer
	private Instance<Task> analyzers;

	@Inject
	private EJavaProject eJavaProject;

	@Inject
	private Selector selector;

	public void run(@Observes AfterStart event) throws IOException {
		//@formatter:off
		selector.selectMany("Selecione a(s) entidade(s)", "entities",
					eJavaProject.getMainEJavaClasses()
						.stream()
						.filter(eJavaClass -> eJavaClass.hasAnnotationByName("Entity"))
						.collect(Collectors.toList())
					);
		//@formatter:on
		selector.selectAndExecuteMany("Escolha a(s) opção(s)", analyzers);
	}
}