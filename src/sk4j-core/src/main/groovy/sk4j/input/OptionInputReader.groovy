package sk4j.input

import sk4j.ConsoleColor;

class OptionInputReader extends InputReader {

	/**
	 * 
	 */
	List<Choosable<?>> options = []

	/**
	 * Uma opção válida é um número e entra o range de opções de 1 a options.size
	 */
	def validOption = { it ==~ /\s*\d\d*/ && (it as Integer) in(1..options.size) }

	/**
	 * Exibe as opções no console.
	 * 
	 * @return
	 */
	def printOptions() {
		def colorMagenta = ConsoleColor.MAGENTA.value
		def colorWhite = ConsoleColor.WHITE.value
		def sortedOptions = options.sort().eachWithIndex { Choosable<?> c , i -> println "${colorMagenta}[${i+1}]${colorWhite} ${c.choiseLabel} " }
	}
}
