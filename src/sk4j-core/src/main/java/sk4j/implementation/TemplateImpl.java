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

	private JtwigTemplate template;

	private String templateName;

	public TemplateImpl(String templateName) {
		super();
		this.templateName = templateName;
	}

	/*
	 * (non-Javadoc)
	 * @see sk4j.template.Template#merge()
	 */
	@Override
	public String merge() {
		this.template = JtwigTemplate.classpathTemplate(templateName);
		return template.render(this.createJtwigModel());
	}

	private JtwigModel createJtwigModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		context.getContext().forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel;
	}

}
