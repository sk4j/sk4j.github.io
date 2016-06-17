package sk4j

abstract class Template {

	def model

	def context = [:]

	/**
	 * Retorna o template da aplicação.
	 * @return String do Template ou File do Template.
	 */
	abstract def template()
	
	abstract String outputPath()
}
