package sk4j

import sk4j.ConsoleColor
import sk4j.SkApp

class App extends SkApp {

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject() || !project.isGradleProject(), message: 'O diretório não possui um projeto maven ou gradle válido.'


	}
}