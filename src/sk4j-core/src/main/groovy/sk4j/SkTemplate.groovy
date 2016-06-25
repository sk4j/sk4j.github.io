package sk4j

import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate

class SkTemplate {

	def context = [:]
	
	JtwigTemplate template

	String merge() {
		JtwigModel jtwigModel = JtwigModel.newModel()
		context.each { key, value -> jtwigModel.with(key, value) }
		template.render(jtwigModel)
	}
}
