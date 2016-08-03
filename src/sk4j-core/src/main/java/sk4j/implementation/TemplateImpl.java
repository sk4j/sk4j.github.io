package sk4j.implementation;

import javax.inject.Inject;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.core.Context;
import sk4j.core.Template;
import sk4j.model.EJavaProject;

public class TemplateImpl implements Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private EJavaProject project;

	private JtwigTemplate template;

	@Override
	public String merge(String templateName) {
		this.template = JtwigTemplate.classpathTemplate(templateName);
		return template.render(this.createJtwigModel());
	}

	private JtwigModel createJtwigModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		context.getContext().forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel.with("project", project);
	}

}