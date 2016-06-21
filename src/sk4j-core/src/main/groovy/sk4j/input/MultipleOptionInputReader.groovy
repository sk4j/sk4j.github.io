package sk4j.input

class MultipleOptionInputReader extends OptionInputReader  {

	/**
	 * Le a(s) opção(s) do console e retorna o(s) choosable(s) correspondente(s)
	 */
	@Override
	def read() {
		inputLabel = "\nDigite o(s) número(s) da(s) opção(s)  ([a] Selecionar todos)"
		printOptions()
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
