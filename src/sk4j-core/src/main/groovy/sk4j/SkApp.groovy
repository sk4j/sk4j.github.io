package sk4j

import groovy.text.GStringTemplateEngine
import sk4j.model.EProject

/**
 * 
 * @author jcruz
 *
 */
abstract class SkApp {

	/**
	 * 
	 */
	def context = [:]

	EProject project

	/**
	 * 
	 */
	def console = new SkConsole()

	def start(args) {
		context['userHome'] = System.getenv("HOME")
		context['sk4jHome'] = "${context.userHome}/git/sk4j.github.io"
		context['projectHome'] = args[0]
		project = new EProject(file: new File(context['projectHome']))
		run()
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	def mkdir(String path) {
		File dir = new File(path)
		if(!dir.exists()) {
			dir.mkdirs()
			console.echo "Criando diretório: ${dir.absolutePath}"
		}
	}

	/**
	 * 
	 * @param path
	 * @param templateClass
	 * @return
	 */
	def file(String path, Class<? extends SkTemplate> templateClass) {
		SkTemplate sktemplate = templateClass.newInstance()
		def engine = new GStringTemplateEngine()
		sktemplate.context = context
		def template = engine.createTemplate(sktemplate.template()).make([context:sktemplate.context])
		console.echo "Criando arquivo:   ${path}"
		new File(path) << template.toString()
	}

	/**
	 * Método que deverá sr implementado pela aplicação Sk.
	 */
	abstract void run()
}
