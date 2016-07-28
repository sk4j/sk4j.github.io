package sk4j.processor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.api.model.EJavaPackage;
import sk4j.core.Processor;
import sk4j.core.ProcessorId;
import sk4j.core.console.reader.ReadConf;

@ProcessorId(1)
public class EditMBProcessor implements Processor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	@Inject
	private FS fs;

	@Inject
	private Template template;

	@Override
	public void process() throws IOException {
		/*
		List<FileChooser> viewsDir = context.getProject().getDirs()
				.stream()
				.filter(dir -> dir.getAbsolutePath().contains("/src/main/java/"))
				.filter(dir -> dir.getName().endsWith("view") || dir.getName().endsWith("Page"))
				.map(FileChooser::new)
				.collect(Collectors.toList());
				*/

		//@formatter:off
		List<EJavaPackage> viewsPackage = context.getProject().getSrcMainJavaPackages()
																.stream()
																.filter(javaPackage -> javaPackage.getName().endsWith("Page"))
																.collect(Collectors.toList());
												
								
		//@formatter:on

		if (viewsPackage.isEmpty()) {
			console.exit("O projeto não possui nenhum pacote view ou page.");
		}

		EJavaPackage selectedPackage = console.readOption("Selecione o pacote", viewsPackage);

		context.putItem("javaPackage", selectedPackage);

		String editClassName = console.read("Digite o nome do MB", "{{javaClass.name}}EditMB", ReadConf.JAVA_CLASS_NAME);
		context.putItem("EDIT_CLASS_NAME", editClassName);

		fs.createFile(selectedPackage.getPath(), editClassName + ".java", template.merge("/templates/edit-java.jtwig"));

	}

}