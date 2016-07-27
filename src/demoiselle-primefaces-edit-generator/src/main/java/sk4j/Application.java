package sk4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.model.EJavaClass;
import sk4j.core.AfterStart;
import sk4j.core.Processor;
import sk4j.core.chooser.StringChooser;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Console console;

	@Inject
	private Context context;

	@Inject
	private Map<Integer, Processor> processors;

	public void run(@Observes AfterStart event) throws IOException {

		//@formatter:off
		EJavaClass selectedEntity = console.readOption("Selecione a entidade",
				context.getProject().getJavaClasses()
						.stream()
						.filter(javaClass -> javaClass.hasAnnotation("Entity"))
						.collect(Collectors.toList()));
		//@formatter:on

		context.putItem("javaClass", selectedEntity);
		StringChooser option1 = new StringChooser(1, "Gerar apenas a classe do managed bean(MB) de edição.");
		StringChooser option2 = new StringChooser(2, "Gerar a classe do managed bean(MB) e o xhtml de edição.");

		StringChooser selectedChooser = console.readOption("Selecione a opção", Arrays.asList(option1, option2));

		processors.get(selectedChooser.getId()).process();
	}
}