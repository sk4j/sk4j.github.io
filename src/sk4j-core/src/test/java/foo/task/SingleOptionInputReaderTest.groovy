package foo.task

import sk4j.input.SingleOptionInputReader

class SingleOptionInputReaderTest {
	static main(args) {
		def optionList = [
			"Atividade",
			"PontoTransmissao",
			"Solicitação"
		]
		SingleOptionInputReader optionInputReader = new SingleOptionInputReader(options: optionList)
		def option =optionInputReader.read()
		println option
	}
}
