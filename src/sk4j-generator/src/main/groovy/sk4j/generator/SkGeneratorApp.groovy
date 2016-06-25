package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp

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
			console.echo ">"*40, ConsoleColor.CYAN
			mkdir "${context.sk4jHome}/src/${context.projectName}"
			mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy"
			mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/"
			mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates"
			mkdir "${context.sk4jHome}/src/${context.projectName}/bin"
			mkdir "${context.sk4jHome}/src/${context.projectName}/build"

			file "${context.sk4jHome}/src/${context.projectName}/.gitignore", template('gitignore')
			file "${context.sk4jHome}/src/${context.projectName}/build.gradle", template('build-gradle')
			file "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/AppGenerator.groovy", template('app-generator')
			file "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates/readme.txt", template('readme-txt')
			
			console.echo "<"*40, ConsoleColor.CYAN
		}
	}
}
