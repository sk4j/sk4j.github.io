package sk4j

/**
 * 
 * @author jcruz
 *
 */
class SkSystem {
	/**
	 *
	 */
	SkConsole console = new SkConsole()

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
}
