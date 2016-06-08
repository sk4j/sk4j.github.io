package foo.task

import sk4j.Task

class DaoTask extends Task {

	@Override
	public void doTask() {
		println context.model
	}
}
