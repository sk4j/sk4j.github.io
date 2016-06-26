
package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp

class AppGenerator extends SkApp {

	static main(args) {
		new AppGenerator().start(args)
	}

	@Override
	public void run() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject(), message: 'O diretório não possui um projeto maven válido.'
    	// Sair do gerador se o projeto não possuir nenhum arquivo java.		 
		quit condition: project.javaFiles.isEmpty(), message: 'O projeto não possui nenhum arquivo java.'
		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		// Exibe no console as opções de seleção das entidades
		def selectedEntities = console.readopts('Seleciona a(s) entidade(s)',entities)
		// Cria o arquivo *DAO.java com o template 'dao.jtwig'
		selectedEntities.each { file path:"${it.path}../persistence", 
									 name:"${it.name}DAO.java", 
									 template: 'dao', 
									 model: it }
	}
}
