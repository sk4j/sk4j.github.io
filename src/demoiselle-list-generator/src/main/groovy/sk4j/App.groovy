package sk4j


class App extends SkApp {

	static main(args) {
		new App().start(args)
	}

	@Override
	public void run() {
		checkProject()
	}
	
	/*
	 * 
	 */
	private checkProject() {
		// Sai do gerador se o diretório de execução não for um projeto maven.
		quit condition: !project.isMavenProject(), message: 'O diretório não possui um projeto maven válido.'
		// Sair do gerador se o projeto não possuir nenhum arquivo java.
		quit condition: project.javaFiles.isEmpty(), message: 'O projeto não possui nenhum arquivo java.'
	}
}