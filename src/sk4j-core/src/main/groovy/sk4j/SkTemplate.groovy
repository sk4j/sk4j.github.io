package sk4j

import org.jtwig.JtwigModel

/**
 * 
 * Classe responsável por manipular o arquivo de template.
 * 
 */
import org.jtwig.JtwigTemplate

class SkTemplate {

	def context = [:]

	JtwigTemplate template

	/**
	 * Mescla o template com o model.
	 * 
	 * @return
	 */
	String merge() {
		SkConsole console = new SkConsole()
		JtwigModel jtwigModel = JtwigModel.newModel()
		context.each { key, value -> 
			if(value) { 
				console.log "Variável do template: ${key} => ${value}"
				jtwigModel.with(key, value) 
			}
		}
		template.render(jtwigModel)
	}
}
