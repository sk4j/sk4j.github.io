package sk4j.input

class SingleOptionInputReader extends OptionInputReader {

	/**
	 * Le a opção do console e retorna o choosable correspondente
	 */
	@Override
	def read() {
		if(!inputLabel) {
			inputLabel = "Digite o número da opção"
		}
		printOptions()
		super.read()
		boolean valid = validOption(inputValue)
		if(!valid) {
			exit()
		}
		options[(inputValue as Integer)-1]
	}
}
