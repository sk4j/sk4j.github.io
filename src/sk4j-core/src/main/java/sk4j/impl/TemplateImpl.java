package sk4j.impl;

import javax.inject.Inject;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.api.Context;
import sk4j.api.Template;
import sk4j.utils.StringTool;

public class TemplateImpl implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private StringTool st;

	private JtwigTemplate template;

	@Override
	public String merge(String templateName) {
		this.template = JtwigTemplate.classpathTemplate(templateName);
		return template.render(this.createJtwigModel());
	}

	private JtwigModel createJtwigModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		context.get().forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel.with("st", st);
	}

}
