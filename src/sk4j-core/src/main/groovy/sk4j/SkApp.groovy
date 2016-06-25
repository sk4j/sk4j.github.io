package sk4j

import org.jtwig.JtwigTemplate

import sk4j.model.EModel
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

		console.with {
			echo "-"*40
			echo "USER_HOME: ${context.userHome}"
			echo "SK4J_HOME: ${context.sk4jHome}"
			echo "PROJECT_HOME: ${context.projectHome}"
			echo "-"*40
		}

		project = new EProject(file: new File(context['projectHome']), path: context['projectHome'])
		beforeRun()
		try {
			run()
		} catch (Exception e) {
			exit(e.getMessage())
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	def mkdir(String path) {
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value
		File dir = new File(path)
		if(!dir.exists()) {
			dir.mkdirs()
			console.echo "${cyanColor}>>>${console.whiteColor} Criando diretório:  ${dir.absolutePath}"
			return
		}
		console.echo "${cyanColor}>>> ${grayColor}Diretório existente: ${dir.absolutePath}${console.whiteColor}"
	}

	/**
	 * 
	 * @param path
	 * @param templateClass
	 * @return
	 */
	def file(params) {
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value
		File file = new File("${params.path}/${params.name}")
		if(file.exists()) {
			console.echo "${cyanColor}>>> ${grayColor}Arquivo existente:  ${params.path}/${params.name}${console.whiteColor}"
			return
		}
		console.echo "${cyanColor}>>>${console.whiteColor} Criando arquivo:    ${params.path}/${params.name}"
		this.context['model'] = params.model
		SkTemplate sktemplate =	new SkTemplate(template: JtwigTemplate.classpathTemplate("/templates/${params.template}.jtwig"), context: this.context)
		file << sktemplate.merge()
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
		console.echo ""
		console.echo "*"*40, ConsoleColor.RED
		console.echo message, ConsoleColor.RED
		System.exit(1)
	}


	/**
	 * Método que deverá sr implementado pela aplicação Sk.
	 */
	abstract void run()
}
