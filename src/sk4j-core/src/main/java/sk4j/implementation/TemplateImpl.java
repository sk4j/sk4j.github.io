package sk4j.implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.console.Colorize;
import sk4j.core.Beans;
import sk4j.core.Context;
import sk4j.core.Log;
import sk4j.template.Template;

public class TemplateImpl implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context = Beans.getReference(Context.class);

	private Log log = Beans.getReference(Log.class);

	private final String CREATE_ID = Colorize.bold(Colorize.blue("[CREATE]"));

	/*
	 * (non-Javadoc)
	 * @see sk4j.template.Template#merge()
	 */
	@Override
	public String merge(String templateName) {
		return JtwigTemplate.classpathTemplate(String.format("/templates/%s.jtwig", templateName)).render(this.createJtwigModel());
	}

	/*
	 * (non-Javadoc)
	 * @see sk4j.template.Template#mergeAndCreateFile(java.lang.String, java.lang.String)
	 */
	@Override
	public void mergeAndCreateFile(String templateName, String path) {

	}

	/*
	 * Cria um model do template e popula com as variáveis do context.
	 */
	private JtwigModel createJtwigModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		context.getContext().forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel;
	}

	private void write(Path path, String content) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(path);
		writer.write(content);
		writer.flush();
		writer.close();
		log.format("%s\t%s", CREATE_ID, Colorize.bold(Colorize.blue(path.toFile().getAbsolutePath())));
	}

}
