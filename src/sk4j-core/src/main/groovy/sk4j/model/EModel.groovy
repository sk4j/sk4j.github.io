package sk4j.model

import groovy.text.GStringTemplateEngine
import sk4j.SkTemplate

abstract class EModel<T>  {

	SkTemplate template


	/**
	 * 
	 * @param templateClass
	 * @return
	 */
	String merge(Class<? extends SkTemplate> templateClass) {
		this.template = templateClass.newInstance()
		template.model = this
		Writable t = new GStringTemplateEngine().createTemplate(template.template()).make([context: template.context, model: template.model])
		t.toString()
	}

	String plus(Class<? extends SkTemplate> templateClass) {
		this.merge(templateClass)
	}
}
