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
	
	abstract public void process();
}
