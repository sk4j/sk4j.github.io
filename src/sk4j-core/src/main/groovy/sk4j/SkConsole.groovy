package sk4j

import sk4j.input.InputReader

class SkConsole {

	enum Color {
		WHITE('\033[0m'),
		BLUE('\033[94m'),
		YELLOW('\033[93m'),
		MAGENTA('\033[95m'),
		CYAN('\033[96m'),
		RED('\033[91m')

		String value

		public Color(String value) {
			this.value = value
		}

		public String getValue() {
			return value
		}
	}

	static def white = Color.WHITE.value

	/**
	 * 
	 * Exibe um texto no console.
	 * 
	 * @param message Texto.
	 * @return
	 */
	static def echo(String message) {
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
	static def echo(String message, Color color) {
		println "${color.value}${message}${white}"
	}
	
	static def caption(String message) {
		def yellow = Color.YELLOW.value
		println "${yellow}${message}${white}"
	}

	/**
	 * Exibe um prompt para entrada de dados do usuário.
	 */
	static def readLine(inputLabel) {
		new InputReader(inputLabel: "$inputLabel").read()
	}
	
	static def readOption(inputLabel) {
		
	}
	
	static def readOptions(inputLabel) {
		
	}
}
