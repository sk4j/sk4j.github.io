package foo.task

import sk4j.input.MultipleOptionInputReader

class MultipleOptionInputReaderTest {
	static main(args) {
		def optionList = [
			"Atividade",
			"PontoTransmissao",
			"Solicitação"
		]
		MultipleOptionInputReader optionInputReader = new MultipleOptionInputReader(options: optionList)
		def options = optionInputReader.read()
		
		options.each { println it }
	}
}
