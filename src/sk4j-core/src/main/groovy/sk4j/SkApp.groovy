package sk4j

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
	
	/**
	 * 
	 */
	Skfs fs = new Skfs()
	
	/**
	 * 
	 */
	SkSystem system = new SkSystem()
	
	/**
	 * 
	 * @param args
	 */
	def start(args) {
		context['userHome'] = System.getenv("HOME")
		context['sk4jHome'] = "${context.userHome}/git/sk4j.github.io"
		context['projectHome'] = args[0]

		console.with {
			echo ""
			echo "-"*40
			echo " USER_HOME: ${context.userHome}"
			echo " SK4J_HOME: ${context.sk4jHome}"
			echo " PROJECT_HOME: ${context.projectHome}"
			echo "-"*40
			echo ""
		}

		project = new EProject(file: new File(context['projectHome']), path: context['projectHome'])
		try {
			run()
		} catch (Exception e) {
			system.exit(e.getMessage())
		}
	}
	
	/**
	 * Sai do aplicativo dada uma condição.
	 *
	 * @param params. Mapa com os parâmetros de saida. Chaves do mapa:
	 * 		  condition: boolean = Condição para saída do application
	 * 		  message: String = Mensagem de saída
	 *
	 */
	def quit(params) {
		boolean condition = params.condition
		String message = params.message
		if(condition) { system.exit(message) }
	}
	
	/**
	 * 
	 * Instancia e executa um processor.
	 * 
	 * @param delegateProcessorClass Classe Processor.
	 */
	protected <T extends DelegateProcessor> void execute(Class<T> delegateProcessorClass) {
		DelegateProcessor delegateProcessor = delegateProcessorClass.newInstance()
		delegateProcessor.project = this.project
		delegateProcessor.context = this.context
		delegateProcessor.process()
	}

	/**
	 * Método que deverá sr implementado pela aplicação Sk.
	 */
	abstract void run()
}
