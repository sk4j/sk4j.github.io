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
		File dir = new File(path)
		if(!dir.exists()) {
			dir.mkdirs()
			console.echo "${cyanColor}>>>${console.whiteColor} Criando diretório: ${dir.absolutePath}"
		}
	}

	/**
	 * 
	 * @param path
	 * @param templateClass
	 * @return
	 */
	def file(String path, SkTemplate sktemplate) {
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value
		File file = new File(path)
		if(file.exists()) { 
			console.echo "${cyanColor}>>> ${grayColor}Arquivo existente: ${path}${console.whiteColor}"
			return
		}
		console.echo "${cyanColor}>>>${console.whiteColor} Criando arquivo:   ${path}"
		file << sktemplate.merge()
	}

	/**
	 * 
	 * @param templateName
	 * @return
	 */
	SkTemplate template(String templateName) {
		new SkTemplate(template: JtwigTemplate.classpathTemplate("/templates/${templateName}.jtwig"), context: this.context)
	}

	/**
	 * 
	 * @param templateName
	 * @param model
	 * @return
	 */
	public <T extends EModel> SkTemplate template(String templateName, T model) {
		this.context['model'] = model
		new SkTemplate(template: JtwigTemplate.classpathTemplate("/templates/${templateName}.jtwig"), context: this.context)
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
