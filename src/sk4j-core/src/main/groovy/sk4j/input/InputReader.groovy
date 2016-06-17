package sk4j.input

class InputReader {

	def inputValue

	def inputLabel = "Digite: "

	/**
	 * Le a entrada do usuário.
	 * 
	 * @return String de entrada do usuário
	 */
	def read() {
		Console console = System.console();
		console.readLine("${inputLabel}: ");
	}

	def exit() {
		println "Opção inválida: ${inputValue}"
		System.exit(1)
	}
}
