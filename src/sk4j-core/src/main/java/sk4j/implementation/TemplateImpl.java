package sk4j.implementation;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.core.Beans;
import sk4j.core.Context;
import sk4j.template.Template;

public class TemplateImpl implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context = Beans.getReference(Context.class);

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

}
