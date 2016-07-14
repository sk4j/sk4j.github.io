package sk4j;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.MainApp;
import sk4j.core.model.EJavaFile;

public class DemoiselleDaoGenerator extends MainApp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private Context ctx;

	@Inject
	private Console console;

	@Inject
	private Template template;

	public static void main(String[] args) {
		new DemoiselleDaoGenerator().init(args);
	}

	@Override
	protected void beforeRun() throws IOException {
		validateProject();
	}

	@Override
	public void run() throws IOException {
		List<EJavaFile> entities = ctx.getProject().getJavaFiles().stream().filter(e -> e.hasAnnotation("Entity"))
				.collect(Collectors.toList());
		List<EJavaFile> selectedEntities = console.readOptions("Selecione a(s) entidade(s): ", entities);
		selectedEntities.stream().forEach(this::createDAO);
	}

	private void createDAO(EJavaFile javaFile) {
		ctx.putItem("javaFile", javaFile);
		String daoPath = javaFile.getPath() + "../persistence";
		String daoFile = javaFile.getName() + "DAO.java";
		fs.createFile(daoPath, daoFile, template.merge("dao-java"));
	}

	private void validateProject() throws IOException {
		if (!ctx.getProject().isMavenProject()) {
			console.exit("O diretório atual não possui um projeto maven.");
		}
		if (ctx.getProject().getJavaFiles().isEmpty()) {
			console.exit("O projeto não possui classes java.");
		}
	}
}