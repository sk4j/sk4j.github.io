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

		def projectDir = "${context.sk4jHome}/src/${context.projectName}"

		fs.mkdir "${projectDir}"
		fs.mkdir "${projectDir}/src/main/groovy"
		fs.mkdir "${projectDir}/src/main/groovy/sk4j/generator/"
		fs.mkdir "${projectDir}/src/main/resources/templates"
		fs.mkdir "${projectDir}/bin"
		fs.mkdir "${projectDir}/build"

		fs.createFile path: "${projectDir}", name: ".gitignore", template: 'gitignore'
		fs.createFile path: "${projectDir}", name: "build.gradle", template: 'build-gradle'
		fs.createFile path: "${projectDir}/src/main/groovy/sk4j/generator", name: "AppGenerator.groovy", template: 'app-generator'
		fs.createFile path: "${projectDir}/src/main/resources/templates", name: "readme.txt", template: 'readme-txt'
		fs.createFile path: "${projectDir}/src/main/resources/", name: "description.txt", content: context['projectDesc']
	}
}
