package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp

class SkGeneratorApp extends SkApp {

	static main(args) {
		new SkGeneratorApp().start(args)
	}

	@Override
	public void run() {
		/*
		 * 
		 */
		context['projectName'] = console.readln('Digite o nome do projeto')
		context['projectDesc'] = console.readln('Digite a descrição do projeto')

		quit condition: context['projectName'].isEmpty(), message: 'Nome de projeto inválido.'
		quit condition: context['projectDesc'].isEmpty(), message: 'Descrição do projeto inválida.'

		mkdir "${context.sk4jHome}/src/${context.projectName}"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator/"
		mkdir "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates"
		mkdir "${context.sk4jHome}/src/${context.projectName}/bin"
		mkdir "${context.sk4jHome}/src/${context.projectName}/build"
		
		/*
		 * Cria o arquivo .gitignore.
		 * Utiliza o arquivo de template gitignore.jtwig
		 */
		file path: "${context.sk4jHome}/src/${context.projectName}",
			 name: ".gitignore" ,
			 template: 'gitignore'
		/*
		 * Cria o arquivo build.gradle
		 */
		file path: "${context.sk4jHome}/src/${context.projectName}",
			 name: "build.gradle" ,
			 template: 'build-gradle'
		/*
		 * Cria o arquivo src/main/groovy/sk4j/generator/AppGenerator.groovy
		 */
		file path: "${context.sk4jHome}/src/${context.projectName}/src/main/groovy/sk4j/generator",
			 name: "AppGenerator.groovy" ,
			 template: 'app-generator'
		/*
		 * Cria o arquivo src/main/resources/templates/readme.txt
		 */
		file path: "${context.sk4jHome}/src/${context.projectName}/src/main/resources/templates",
			 name: "readme.txt" ,
			 template: 'readme-txt'
		/*
		 * Cria o arquivo /src/main/resources/description.txt
		 */
		file path: "${context.sk4jHome}/src/${context.projectName}/src/main/resources/",
			 name: "description.txt",
			 content: context['projectDesc']
	}
}
