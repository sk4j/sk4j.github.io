package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp
import sk4j.generator.template.AppGeneratorTemplate
import sk4j.generator.template.BuildGradleTemplate
import sk4j.generator.template.GitignoreTemplate

class SkGeneratorApp extends SkApp {

	static main(args) {
		new SkGeneratorApp().start(args)
	}

	@Override
	public void run() {
		console.echo '*** SkGeneratorApp ***', ConsoleColor.YELLOW
		context['projectName'] = console.readln('Digite o nome do projeto')

		if(!context['projectName'].isEmpty()) {
			console.echo ""
			console.echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", ConsoleColor.CYAN
			mkdir "${context.sk4jHome}/src/${context.projectName}"
			mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy"
			mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/template"
			mkdir "${context.sk4jHome}/src/${context.projectName}/bin"
			mkdir "${context.sk4jHome}/src/${context.projectName}/build"

			file "${context.sk4jHome}/src/${context.projectName}/build.gradle", BuildGradleTemplate
			file "${context.sk4jHome}/src/${context.projectName}/.gitignore", GitignoreTemplate
			file "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/AppGenerator.groovy", AppGeneratorTemplate
		}
	}
}
