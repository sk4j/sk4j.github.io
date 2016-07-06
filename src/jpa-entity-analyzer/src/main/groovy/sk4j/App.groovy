package sk4j

import java.text.SimpleDateFormat

import sk4j.analyzer.EntityHasHashCodeAndEqualsAnalyzer
import sk4j.model.EJavaFile

class App extends SkApp {

	def results = []

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject(), message: 'O diretório não possui um projeto maven ou gradle válido.'

		quit condition: project.javaFiles.isEmpty(), message: 'O projeto não possui nenhum arquivo java.'
		// Filtra no projeto todas as classes java com a annotation @Entity
		def entities = project.javaFiles.findAll { it.hasAnnotation('Entity') }
		// Exibe no console as opções de seleção das entidades
		def selectedEntities = console.readopts('Selecione a(s) entidade(s)',entities)
		console.log "Entidades selecionadas: ${selectedEntities*.name}"

		selectedEntities.each { EJavaFile jf ->
			context['javaFileAnalyzerResult'] = new JavaFileAnalyzerResult(javaFile: jf)
			this.executeAnalyzers(jf)
			results << context['javaFileAnalyzerResult']
		}

		generateHtmlAnalyzerResult()
	}

	private void executeAnalyzers(EJavaFile jf) {
		execute(EntityHasHashCodeAndEqualsAnalyzer)
	}

	private void generateHtmlAnalyzerResult() {
		def writer = new StringWriter()  // html is written here by markup builder
		def markup = new groovy.xml.MarkupBuilder(writer)
		markup.html {
			results.each { JavaFileAnalyzerResult jfar ->
				h4(jfar.javaFile.name) {
					table {
						jfar.results.each { String output ->
							tr { td(output) }
						}
					}
				}
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
		def date = sdf.format(new Date())
		fs.mkdir "$context.sk4jHome/tmp"
		File file = new File("$context.sk4jHome/tmp/jpa-entity-analyzer-${date}.html")
		def w = file.newWriter()
		w << writer.toString()
		w.close()
		system.browser(file.toURI().toURL().toString())
	}
}