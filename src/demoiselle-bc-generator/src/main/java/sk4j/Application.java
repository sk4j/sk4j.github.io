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
import sk4j.api.model.EJavaClass;
import sk4j.event.AfterStart;

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
		List<EJavaClass> selectedEntities = console.readOptions("Selecione a(s) entidade(s)",
				context.getJavaProject().getJavaClasses()
						.stream()
						.filter(javaClass -> javaClass.hasAnnotationByName("Entity"))
						.collect(Collectors.toList()));
		
		selectedEntities.stream().forEach(javaClass -> {
			//Coloca o javaClass atual no contexto.
			context.putItem("javaClass", javaClass);
			//Retorna o diretório que termina com persistence no mesmo nível do javaClass. Sob até 2 níveis de diretório na busca caso necessário.
			String siblingPath = fs.findSiblingPath(javaClass.getPath(),"business",2);
			//Cria o arquivo de DAO no diretório encontrado acima utilizando o template dao-java.jtwig.
			fs.createFile(siblingPath, "{{javaClass.name}}BC.java", template.merge("/templates/bc-java.jtwig"));
		});
		//@formatter:on
	}
}