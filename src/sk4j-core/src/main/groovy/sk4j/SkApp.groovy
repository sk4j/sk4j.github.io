package sk4j

import org.apache.commons.io.FilenameUtils

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
	SkConsole console = new SkConsole()

	def start(args) {
		context['userHome'] = System.getenv("HOME")
		context['sk4jHome'] = "${context.userHome}/git/sk4j.github.io"
		context['projectHome'] = args[0]
		project = new EProject(file: new File(context['projectHome']), path: context['projectHome'])
		beforeRun()
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
		file(path,template.toString())
	}

	/**
	 * 
	 * Cria o arquivo com o conteudo correspondente.
	 * 
	 * @param path
	 * @param fileContent
	 * @return
	 */
	def file(String path, String fileContent) {
		String filePath = FilenameUtils.getPath(path)
		if(!new File(filePath).exists()) {
			mkdir(filePath)
		}
		console.echo "Criando arquivo:   ${path}"
		new File(path) << fileContent
	}

	void beforeRun() {
	}

	/**
	 * Finaliza a execução do programa de forma anormal (status 1) com uma mensagem no console.
	 * 
	 * @param message
	 * @return
	 */
	def exit(String message) {
		console.echo message, ConsoleColor.RED
		System.exit(1)
	}


	/**
	 * Método que deverá sr implementado pela aplicação Sk.
	 */
	abstract void run()
}
