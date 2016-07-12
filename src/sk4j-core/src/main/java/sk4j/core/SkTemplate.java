package sk4j.core;

import org.jtwig.JtwigTemplate;

public class SkTemplate {

	private JtwigTemplate template;

	public SkTemplate(String templateName) {
		super();
		this.template = JtwigTemplate.classpathTemplate(String.format("/templates/%s.jtwig", templateName));
	}

	/**
	 * 
	 * @return String com o template e o modelo mesclado.
	 */
	public String merge() {
		return template.render(SkContext.get().getModel());
	}

}
