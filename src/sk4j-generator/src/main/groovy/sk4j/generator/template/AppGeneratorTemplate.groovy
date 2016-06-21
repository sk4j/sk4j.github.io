package sk4j.generator.template

import sk4j.SkTemplate

class AppGeneratorTemplate extends SkTemplate {

	@Override
	def template() {
		'''
package sk4j.generator

import sk4j.ConsoleColor
import sk4j.SkApp
import sk4j.generator.template.AppGeneratorTemplate
import sk4j.generator.template.BuildGradleTemplate
import sk4j.generator.template.GitignoreTemplate

class AppGenerator extends SkApp {

	static main(args) {
		new AppGenerator().start(args)
	}

	@Override
	public void run() {
		console.echo '*** ${context.projectName} ***', ConsoleColor.YELLOW
		//TODO Generator Code 
		
	}
}
	'''
		
	
	}

}
