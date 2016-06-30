package sk4j.generator

import sk4j.SkApp
import sk4j.model.EJavaFile

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
		def selectedEntities = console.readopts('Selecione a(s) entidade(s)',entities)
		console.log "Entidades selecionadas: ${selectedEntities*.name}"
		// Cria o arquivo *BC.java com o template 'bc.jtwig'
		selectedEntities.each { EJavaFile jf ->
			fs.createFile path:"${jf.path}../business", name:"${jf.name}BC.java", template: 'bc', model: jf
		}
	}
}