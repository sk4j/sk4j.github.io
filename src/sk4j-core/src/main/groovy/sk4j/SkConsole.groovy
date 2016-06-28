package sk4j

import sk4j.input.Choosable
import sk4j.input.InputReader
import sk4j.input.MultipleOptionInputReader
import sk4j.input.SingleOptionInputReader

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
	 * Exibe um prompt para entrada de dados do usuário.
	 */
	def readln(String inputLabel) {
		new InputReader(inputLabel: "$inputLabel").read()
	}

	/**
	 * 
	 * @param inputLabel
	 * @return
	 */
	def readopt(String inputLabel, List<? extends Choosable<?>> options) {
		new SingleOptionInputReader(inputLabel: inputLabel, options: options).read()
	}
	
	/**
	 *
	 * @param inputLabel
	 * @return
	 */
	def readopt(List<? extends Choosable<?>> options) {
		new SingleOptionInputReader(options: options).read()
	}

	/**
	 * 
	 * @param inputLabel
	 * @return
	 */
	def readopts(String inputLabel, List<? extends Choosable<?>> options) {
		new MultipleOptionInputReader(inputLabel: inputLabel, options: options).read()
	}
	
	/**
	 *
	 * @param inputLabel
	 * @return
	 */
	def readopts(List<? extends Choosable<?>> options) {
		new MultipleOptionInputReader(options: options).read()
	}
	
	def log(message) {
		def yellowColor = ConsoleColor.YELLOW.value
		println "${yellowColor}- ${message}${whiteColor}"
	}
}
