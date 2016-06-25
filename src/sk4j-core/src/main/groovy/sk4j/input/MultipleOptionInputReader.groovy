package sk4j.input

import sk4j.ConsoleColor

class MultipleOptionInputReader extends OptionInputReader  {

	/**
	 * Le a(s) opção(s) do console e retorna o(s) choosable(s) correspondente(s)
	 */
	@Override
	def read() {
		def colorMagenta = ConsoleColor.MAGENTA.value
		def colorWhite = ConsoleColor.WHITE.value
		
		inputLabel = "\nDigite o(s) número(s) da(s) opção(s)"
		printOptions()
		println "${colorMagenta} a >${colorWhite} Selecionar todos "
		super.read()
		boolean valid = inputValue.equals("a") || inputValue.split(',').every { validOption(it) }
		if(!valid) exit()
		inputValue.equals("a") ?
				this.options :
				inputValue
				.split(",")
				.collect { it as Integer }
				.unique()
				.collect { options[it-1] }
	}
	
}
