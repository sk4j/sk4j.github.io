package sk4j

abstract class SkTemplate {

	def model

	def context = [:]

	/**
	 * Retorna o template da aplicação.
	 * @return String do Template ou File do Template.
	 */
	abstract String template()
}
