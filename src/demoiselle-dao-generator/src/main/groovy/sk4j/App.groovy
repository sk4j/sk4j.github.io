
package sk4j

import org.jboss.forge.roaster.model.source.JavaClassSource

import sk4j.SkApp
import sk4j.model.EJavaFile

class App extends SkApp {

	def selectedEntities = []

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		checkProject()
		selectEntities()
		createDaoFileForEntities()
	}

	/*
	 * 
	 */
	private createDaoFileForEntities() {
		// Cria o arquivo *DAO.java com o template 'dao.jtwig'
		selectedEntities.each { EJavaFile jf ->
			fs.createFile path:"${jf.path}../persistence", name:"${jf.name}DAO.java", template: 'dao', model: jf
		}
	}

	private selectEntities() {
		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		// Exibe no console as opções de seleção das entidades
		selectedEntities = console.readopts('Selecione a(s) entidade(s)',entities)
		console.log "Entidades selecionadas: ${selectedEntities*.name}"
	}

	/*
	 * 
	 */
	private checkProject() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject(), message: 'O diretório não possui um projeto maven válido.'
		// Sair do gerador se o projeto não possuir nenhum arquivo java.
		quit condition: project.javaFiles.isEmpty(), message: 'O projeto não possui nenhum arquivo java.'
	}
}
