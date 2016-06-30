package sk4j.generator

import sk4j.SkApp
import sk4j.input.FileChooser

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
		def selectedEntity = console.readopt('Selecione a entidade',entities)
		console.log "Entidade selecionada: ${selectedEntity.name}\n"
		// Seleciona os atributos da entidade selecionada
		context['attributes'] = console.readopts('Selecione o(s) atributo(s)', selectedEntity.javaAttributes)
		console.log "Atributos selecionados: ${context.attributes*.name}\n"
		
		// Exibe prompt para entrada do nome do EditMB. Caso não seja digitado nada o opção defaul sera: 
		// [Nome da Entidade]EditDialogMB
		String editMBNameDefault = "${selectedEntity.name}EditDialogMB"
		def editMBName = console.readln("Digite o nome do EditMB (default: ${editMBNameDefault})")
		editMBName = editMBName? editMBName : editMBNameDefault
		console.log "Nome do EditMB: ${editMBName}\n"
		
		// Seleciona como opção todos os diretórios em src/main/java que terminam com 'Page'.
		def pagePackageOptions = project.dirs
									.findAll { it.name.endsWith('Page') && it.absolutePath.startsWith("${project.path}/src/main/java") }
									.collect { new FileChooser(it) }
									.sort()
		// Exibe o prompt para escolha com os itens acima. E retorna apenas 1 elemento da opção.
		def selectedPackagePage = console.readopt('Selecione o pacote da página (em src/main/java/)',pagePackageOptions)
		console.log "Página selecionada: ${selectedPackagePage.file.name}\n"
		
		// Seleciona como opção todos os diretórios em src/main/webapp que terminam com 'Page'.
		def pageDirOptions = project.dirs
								   .findAll { it.name.endsWith('Page') && it.absolutePath.startsWith("${project.path}/src/main/webapp") }
								   .collect { new FileChooser(it) }
								   .sort()
        // Exibe o prompt para escolha com os itens acima. E retorna apenas 1 elemento da opção.
		def selectedDirPage = console.readopt('Selecione o diretório da página (em src/main/webapp/)',pageDirOptions)
		console.log "Página selecionada: ${selectedDirPage.file.name}\n"
	}
}