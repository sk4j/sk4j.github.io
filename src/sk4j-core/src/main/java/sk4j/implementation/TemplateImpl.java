package sk4j.implementation;

import java.io.IOException;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.core.Beans;
import sk4j.core.Context;
import sk4j.file.EPaths;
import sk4j.file.FS;
import sk4j.model.EPath;
import sk4j.template.Template;

public class TemplateImpl implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context = Beans.getReference(Context.class);

	private FS fs = Beans.getReference(FS.class);

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
	public void mergeAndCreateFile(String templateName, EPath epath) throws IOException {
		String content = this.merge(templateName);
		fs.mkdir(EPaths.get(epath.getPath().getParent()));
		fs.write(epath.getPath(), content);
	}

	/*
	 * Cria um model do template e popula com as variáveis do context.
	 */
	private JtwigModel createJtwigModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		context.getContext().forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel;
	}

}
