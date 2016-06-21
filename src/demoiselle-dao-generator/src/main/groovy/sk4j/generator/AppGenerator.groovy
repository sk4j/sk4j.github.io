
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

		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }

		// Exibe no console as opções de seleção das entidades
		def selectedEntities = console.readopts(entities)

		selectedEntities.each { EJavaFile javaFile ->
			// Cria o arquivo *DAO.java com o template DaoGeneratorTemplate
			file "${javaFile.path}../persistence/${javaFile.name}DAO.java", javaFile.merge(DaoGeneratorTemplate)
		}
	}
}
