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
		try {
			run()
		} catch (Exception e) {
			exit(e.getMessage())
		}
	}

	/**
	 * 
	 * Cria um diretório.
	 * 
	 * @param path. Caminho do diretório.
	 * 
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
	 * Cria um arquivo.
	 * 
	 * @param params. Mapa com os parâmetros de criação do arquivo. Chaves do mapa: 
	 * 		  path: String = Caminho do arquivo.
	 * 		  name: String = Nome do arquivo.
	 * 		  template: String = Nome do template localizado.
	 * 		  model: Chooseble = Modelo utilizando no template.
	 *
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

	/**
	 * Sai do aplicativo. 
	 * 
	 * @param params. Mapa com os parâmetros de saida. Chaves do mapa:
	 * 		  condition: boolean = Condição para saída do application
	 * 		  message: String = Mensagem de saída
	 * 
	 */
	def quit(params) {
		boolean condition = params.condition
		String message = params.message

		if(condition) {
			exit(message)
		}
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
