package sk4j.input

import sk4j.SkSystem;

class InputReader {

	SkSystem system = new SkSystem()
	
	def inputValue

	def inputLabel = "Digite: "

	/**
	 * Le a entrada do usuário.
	 * 
	 * @return String de entrada do usuário
	 */
	def read() {
		Console console = System.console();
		inputValue = console.readLine("${inputLabel}: ");
	}

	def exit() {
		system.exit("Opção inválida: ${inputValue}")
	}
}
