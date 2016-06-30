package sk4j

import sk4j.model.EProject

abstract class DelegateProcessor {
	/**
	 *
	 */
	def context = [:]

	EProject project
	/**
	 *
	 */
	SkConsole console = new SkConsole()
	
	/**
	 *
	 */
	Skfs fs = new Skfs()
	
	/**
	 *
	 */
	SkSystem system = new SkSystem()
	
	/**
	 *
	 * Instancia e executa um processor.
	 *
	 * @param delegateProcessorClass Classe Processor.
	 */
	protected <T extends DelegateProcessor> void execute(Class<T> delegateProcessorClass) {
		DelegateProcessor delegateProcessor = delegateProcessorClass.newInstance()
		delegateProcessor.project = this.project
		delegateProcessor.context = this.context
		console.log "Executando o processor ${delegateProcessorClass.name}"
		delegateProcessor.fs.context = this.context
		delegateProcessor.execute()
	}
	
	abstract public void execute();
}
