package sk4j

import sk4j.model.EProject


/**
 * 
 * @author jcruz
 *
 */
class SkContext {

	/**
	 * 
	 */
	EProject project

	/**
	 * 
	 */
	def context = [:]

	/**
	 * 
	 * @param taskParamMap
	 * @return
	 */
	static def task(Class<? extends Task> taskClass) {
		Task task = taskClass.newInstance()
		task.doTask()
	}

	/**
	 * 
	 * @param taskClass
	 * @param taskContext
	 * @return
	 */
	static def task(Class<? extends Task> taskClass, taskContext) {
		Task task = taskClass.newInstance()
		task.context = taskContext
		task.doTask()
	}
}
