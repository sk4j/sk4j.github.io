package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp

class SkGeneratorApp extends SkApp {

	static main(args) {
		new SkGeneratorApp().start(args)
	}

	@Override
	public void run() {
		context['projectName'] = console.readln('Digite o nome do projeto')

		quit condition: context['projectName'].isEmpty(), message: 'Nome de projeto inválido.'

		mkdir "${context.sk4jHome}/src/${context.projectName}"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates"
		mkdir "${context.sk4jHome}/src/${context.projectName}/bin"
		mkdir "${context.sk4jHome}/src/${context.projectName}/build"

		file path: "${context.sk4jHome}/src/${context.projectName}",
			 name: ".gitignore" ,
			 template: 'gitignore'
		file path: "${context.sk4jHome}/src/${context.projectName}",
			 name: "build.gradle" ,
			 template: 'build-gradle'
		file path: "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator",
			 name: "AppGenerator.groovy" ,
			 template: 'app-generator'
		file path: "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates",
			 name: "readme.txt" ,
			 template: 'readme-txt'
	}
}
