package sk4j

import sk4j.ConsoleColor
import sk4j.SkApp

class App extends SkApp {

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		context['projectName'] = console.readln("Digite o nome do projeto")
		
		quit condition: context['projectName'].isEmpty(), message: 'Nome de projeto inválido.'
		
		fs.mkdir "${context.projectHome}/${context.projectName}"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/java/foo"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/resources"
		fs.mkdir "${context.projectHome}/${context.projectName}/src/main/test"
		fs.mkdir "${context.projectHome}/${context.projectName}/target"
		
		fs.createFile path: "${context.projectHome}/${context.projectName}",
			 name: 'pom.xml',
			 template: 'pom-xml'
		fs.createFile path: "${context.projectHome}/${context.projectName}/src/main/java/foo",
			 name: 'App.java',
			 template: 'app-java'
	}
}