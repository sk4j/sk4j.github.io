package sk4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.AfterStart;
import sk4j.core.model.EJavaFile;

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
	private FS fs;

	@Inject
	private Template template;

	public void run(@Observes AfterStart event) throws IOException {
		//@formatter:off
		List<EJavaFile> selectedEntities = console.readOptions("Selecione a entidade",
				context.getProject().getJavaFiles()
						.stream()
						.filter(p -> p.hasAnnotation("Entity"))
						.collect(Collectors.toList()));
		//@formatter:on
		selectedEntities.stream().forEach(p -> {
			context.putItem("javaFile", p);
			fs.createFile("{{javaFile.path}}../persistence", "{{javaFile.name}}DAO.java", template.merge("/templates/dao-java.jtwig"));
		});
	}
}