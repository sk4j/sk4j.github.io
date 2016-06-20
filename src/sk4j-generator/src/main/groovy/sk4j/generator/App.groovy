package sk4j.generator

import sk4j.SkApp
import sk4j.SkConsole
import sk4j.SkConsole.Color
import sk4j.input.InputReader

class App extends SkApp {

	static main(args) {
		App app = new App()
		def sk4jArtifactDir = new File("${app.sk4jHome}/artifact")

		SkConsole.caption "*** Sk4j Generator ***"
	}
}
