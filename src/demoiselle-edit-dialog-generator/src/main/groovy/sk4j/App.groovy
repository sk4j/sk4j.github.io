package sk4j

import sk4j.input.FileChooser
import sk4j.processor.EditMBProcessor

class App extends SkApp {

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		checkProject()
		selectEntityAndAttributes()
		defineEditBeanName()
		selectSrcMainJavaPagePackage()
		selectSrcMainWebappPageDir()
		execute(EditMBProcessor)
	}

	/*
	 * 
	 */
	private defineEditBeanName() {
		// Exibe prompt para entrada do nome do EditMB. Caso não seja digitado nada o opção defaul sera:
		// [Nome da Entidade]EditDialogMB
		String editMBNameDefault = "${context['selectedEntity'].name}EditDialogMB"
		context['editMBName'] = console.readln("Digite o nome do EditMB (default: ${editMBNameDefault})")
		context['editMBName'] = context['editMBName']? context['editMBName'] : editMBNameDefault
		console.log "Nome do EditMB: ${context.editMBName}\n"
	}

	/*
	 * 
	 */
	private selectSrcMainWebappPageDir() {
		// Seleciona como opção todos os diretórios em src/main/webapp que terminam com 'Page'.
		def pageDirOptions = project.dirs
				.findAll { it.name.endsWith('Page') && it.absolutePath.startsWith("${project.path}/src/main/webapp") }
				.collect { new FileChooser(it) }
				.sort()
		// Exibe o prompt para escolha com os itens acima. E retorna apenas 1 elemento da opção.
		context['selectedPageDir'] = console.readopt('Selecione o diretório da página (em src/main/webapp/)',pageDirOptions)
		console.log "Página selecionada: ${context.selectedPageDir.file.name}\n"
	}

	/*
	 * 
	 */
	private selectSrcMainJavaPagePackage() {
		// Seleciona como opção todos os diretórios em src/main/java que terminam com 'Page'.
		def pagePackageOptions = project.dirs
				.findAll { it.name.endsWith('Page') && it.absolutePath.startsWith("${project.path}/src/main/java") }
				.collect { new FileChooser(it) }
				.sort()
		// Exibe o prompt para escolha com os itens acima. E retorna apenas 1 elemento da opção.
		context['selectedPagePackage'] = console.readopt('Selecione o pacote da página (em src/main/java/)',pagePackageOptions)
		console.log "Página selecionada: ${context.selectedPagePackage.file.name}\n"
	}

	/*
	 * 
	 */
	private selectEntityAndAttributes() {
		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		// Exibe no console as opções de seleção das entidades
		context['selectedEntity'] = console.readopt('Selecione a entidade',entities)
		console.log "Entidade selecionada: ${context['selectedEntity'].name}\n"
		// Seleciona os atributos da entidade selecionada
		context['selectedAttributes'] = console.readopts('Selecione o(s) atributo(s)', context['selectedEntity'].javaAttributes)
		console.log "Atributos selecionados: ${context.selectedAttributes*.name}\n"
	}

	/**
	 * Verifica se o projeto é válido e se possui arquivos java. Caso umas das condições falhe sai da app.
	 * 
	 */
	private checkProject() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject(), message: 'O diretório não possui um projeto maven válido.'
		// Sair do gerador se o projeto não possuir nenhum arquivo java.
		quit condition: project.javaFiles.isEmpty(), message: 'O projeto não possui nenhum arquivo java.'
	}
}