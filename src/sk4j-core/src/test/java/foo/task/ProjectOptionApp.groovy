package foo.task

import sk4j.SkApp
import sk4j.input.SingleOptionInputReader;
import sk4j.model.EJavaFile
import sk4j.model.EProject

class ProjectOptionApp extends SkApp {

	static main(args) {
		println System.getProperty("user.dir")
		EProject project = new EProject(file: new File("/opt/workspace-luna/aelis2016"))

		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }

		SingleOptionInputReader optionReader = new SingleOptionInputReader(options: entities)
		def value = optionReader.read()
		println value.name
	}
}
