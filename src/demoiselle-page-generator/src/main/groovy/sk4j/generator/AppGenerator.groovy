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
		
		
		
		// Caminho de diretório da página
		context['pagePackage'] = console.readln("Digite o pacote da página")
		quit condition: context['pagePackage'].isEmpty(), message: 'Caminho da página inválido. '
		context['pagePath'] = context['pagePackage'].replaceAll('\\.', '/')
		console.log "Caminho do pacote: ${project.path}/src/main/java/${context.pagePath}"
		
		// Nome da página
		context['pageName'] = console.readln("Digite o nome da página (com sufixo Page)")
		quit condition: !context['pageName'].endsWith('Page'), message: 'O nome da página de ser sufixada com Page (ex: atividadesPage)'
		context['pageJavaName'] = context['pageName'].replace('Page', 'PG').capitalize()
		console.log "Arquivo java: ${context.pageJavaName}.java"
		
		// Caminho em webapp
		context['pageWebappPath'] = console.readln("Digite o caminho em webapp")
		quit condition: context['pageWebappPath'].isEmpty(), message: 'Caminho inválido.'
		
		
		fs.mkdir "${project.path}/src/main/java/${context.pagePath}/${context.pageName}"
		fs.mkdir "${project.path}/src/main/webapp/${context.pageWebappPath}/${context.pageName}"
		
		fs.createFile path: "${project.path}/src/main/java/${context.pagePath}/${context.pageName}",
					  name: "${context.pageJavaName}.java",
				      template: "page-java"
		
		fs.createFile path: "${project.path}/src/main/webapp/${context.pageWebappPath}/${context.pageName}",
					  name: "index.xhtml",
					  template: "index-xhtml"
		
	}
}