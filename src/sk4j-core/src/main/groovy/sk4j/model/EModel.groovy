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
	def merge(Class<? extends SkTemplate> templateClass) {
		this.template = templateClass.newInstance()
		template.context['model'] = this
		template.init()
		Writable t = new GStringTemplateEngine().createTemplate(template.template()).make(context: template.context)
		t.toString()
	}

	def plus(Class<? extends SkTemplate> templateClass) {
		this.merge(templateClass)
	}
}
