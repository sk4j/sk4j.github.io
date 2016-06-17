package sk4j

import sk4j.input.InputReader

class SkApp {

	def userHome = System.getenv("HOME")

	def sk4jHome = "${userHome}/git/sk4j.github.io"

	def args

	public SkApp(args) {
		super()
		this.args=args
	}


	/**
	 *
	 * @param taskParamMap
	 * @return
	 */
	def task(Class<? extends Task> taskClass) {
		Task task = taskClass.newInstance()
		task.doTask()
	}

	/**
	 *
	 * @param taskClass
	 * @param taskContext
	 * @return
	 */
	def task(Class<? extends Task> taskClass, taskContext) {
		Task task = taskClass.newInstance()
		task.context = taskContext
		task.doTask()
	}
}
