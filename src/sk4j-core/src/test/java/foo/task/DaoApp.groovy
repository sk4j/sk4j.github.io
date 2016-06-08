package foo.task

import sk4j.SkContext

class DaoApp extends SkContext {
	static main(args) {
		SkContext.task(DaoTask, [model:'jose'])
	}
}
