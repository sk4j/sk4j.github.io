
package sk4j.generator

import com.thoughtworks.qdox.model.JavaClass

import sk4j.ConsoleColor
import sk4j.SkApp
import sk4j.generator.template.DaoGeneratorTemplate
import sk4j.model.EJavaFile

class AppGenerator extends SkApp {

	static main(args) {
		new AppGenerator().start(args)
	}

	@Override
	public void run() {
		console.echo '*** demoiselle-dao-generator ***', ConsoleColor.YELLOW

		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		def selectedEntities = console.readopts(entities)

		selectedEntities.each { EJavaFile javaFile ->
			def fileContent = javaFile.merge(DaoGeneratorTemplate)
			file "${javaFile.path}../persistence/${javaFile.name}DAO.java", fileContent
		}
	}
}
