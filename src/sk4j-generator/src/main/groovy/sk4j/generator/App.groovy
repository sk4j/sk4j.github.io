package sk4j.generator

import sk4j.SkApp
import sk4j.SkConsole
import sk4j.SkConsole.Color
import sk4j.input.InputReader

class App extends SkApp {

	public App(args) {
		super(args)
	}

	static main(args) {
		App app = new App(args)
		def sk4jArtifactDir = new File("${app.sk4jHome}/artifact")

		SkConsole.caption "*** Sk4j Generator ***"

		//def projectName = app.readLineFromConsole("Digite o nome do projeto")
		//def packageName = app.readLineFromConsole("Digite o nome do projeto")

		/*
		 sk4jArtifactDir.eachFile { File file ->
		 println file.name
		 }*/
	}
}
