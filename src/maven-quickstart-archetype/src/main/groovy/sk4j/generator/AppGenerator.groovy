package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp

class AppGenerator extends SkApp {

	static main(args) {
		new AppGenerator().start(args)
	}

	@Override
	public void run() {
		context['projectName'] = console.readln("Digite o nome do projeto")
		
		quit condition: context['projectName'].isEmpty(), message: 'Nome de projeto inválido.'
		
		fs.mkdir "${context.projectHome}/${context.projectName}"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/java"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/resources"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/test"
		fs.mkdir "${context.projectHome}/${context.projectName}/target"
		
		fs.createFile path: "${context.projectHome}/${context.projectName}",
			 name: 'pom.xml',
			 template: 'pom-xml'
		fs.createFile path: "${context.projectHome}/${context.projectName}/src/main/java",
			 name: 'App.java',
			 template: 'app-java'
	}
}