package sk4j

import sk4j.input.InputReader

/**
 * 
 * @author jcruz
 *
 */
class SkConsole {

	def whiteColor = ConsoleColor.WHITE.value

	/**
	 * 
	 * Exibe um texto no console.
	 * 
	 * @param message Texto.
	 * @return
	 */
	def echo(String message) {
		println "$message"
	}

	/**
	 * 
	 * Exibe um texto no console com opção de cor.
	 * 
	 * @param message Texto.
	 * @param color Opção de cor disponíveis no enum Color.
	 * @return
	 */
	def echo(String message, ConsoleColor color) {
		println "${color.value}${message}${whiteColor}"
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	def caption(String message) {
		def yellowColor = ConsoleColor.YELLOW.value
		println "${yellowColor}${message}${whiteColor}"
	}

	/**
	 * Exibe um prompt para entrada de dados do usuário.
	 */
	def readLine(inputLabel) {
		new InputReader(inputLabel: "$inputLabel").read()
	}
	
	/**
	 * 
	 * @param inputLabel
	 * @return
	 */
	def readOption(inputLabel) {
		
	}
	
	/**
	 * 
	 * @param inputLabel
	 * @return
	 */
	static def readOptions(inputLabel) {
		
	}
}
