package sk4j.processor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.Processor;
import sk4j.core.ProcessorId;
import sk4j.core.chooser.FileChooser;
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
		//@formatter:off
		List<FileChooser> viewsDir = context.getProject().getDirs()
				.stream()
				.filter(dir -> dir.getAbsolutePath().contains("/src/main/java/"))
				.filter(dir -> dir.getName().endsWith("view") || dir.getName().endsWith("Page"))
				.map(FileChooser::new)
				.collect(Collectors.toList());
		//@formatter:on

		if (viewsDir.isEmpty()) {
			console.exit("O projeto não possui nenhum pacote view ou page.");
		}

		FileChooser selectedChooser = console.readOption("Selecione o pacote", viewsDir);

		String packageName = selectedChooser.getFile().getAbsolutePath().replace(context.replace("{{PROJECT_HOME}}/src/main/java/"), "")
				.replaceAll("/", "\\.");

		context.putItem("SELECTED_PACKAGE", packageName);

		String editClassName = console.read("Digite o nome do MB", "{{javaClass.name}}EditMB", ReadConf.JAVA_CLASS_NAME);
		context.putItem("EDIT_CLASS_NAME", editClassName);

		fs.createFile(selectedChooser.getFile().getAbsolutePath(), editClassName + ".java", template.merge("/templates/edit-java.jtwig"));

	}

}
