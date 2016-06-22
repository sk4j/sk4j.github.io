
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
	public void beforeRun() {
		if(!project.isMavenProject()) exit "O diretório não possui um projeto maven válido."
		if(project.javaFiles.isEmpty()) exit "O projeto não possui nenhuma entidade."
	}

	@Override
	public void run() {
		console.echo '*** demoiselle-dao-generator - Gerador de DAO para o Framework Demoiselle ***\n', ConsoleColor.YELLOW
		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		// Exibe no console as opções de seleção das entidades
		def selectedEntities = console.readopts(entities)
		console.echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", ConsoleColor.CYAN
		// Cria o arquivo *DAO.java com o template DaoGeneratorTemplate
		selectedEntities.each { file "${it.path}../persistence/${it.name}DAO.java", it.merge(DaoGeneratorTemplate) }
	}
}
