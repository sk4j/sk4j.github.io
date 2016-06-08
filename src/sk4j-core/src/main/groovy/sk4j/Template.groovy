package sk4j

abstract class Template {

	def context = [:]

	abstract void init()
	/**
	 * Retorna o template da aplicação.
	 * @return String do Template ou File do Template.
	 */
	abstract def template()
}
