package sk4j

import sk4j.input.InputReader

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

	/**
	 * 
	 */
	def console = new SkConsole()

	def start(args) {
		context['userHome'] = System.getenv("HOME")
		context['sk4jHome'] = "${context.userHome}/git/sk4j.github.io"
	}

	/**
	 * Método que deverá sr implementado pela aplicação Sk.
	 */
	abstract void run()
}
