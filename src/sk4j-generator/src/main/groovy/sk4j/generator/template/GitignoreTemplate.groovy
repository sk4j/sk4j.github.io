package sk4j.generator.template

import sk4j.SkTemplate

class GitignoreTemplate extends SkTemplate {
	@Override
	def template() {
		'''
/bin/
/build/
/.gradle/
/.settings/
/.classpath
/.project

	'''
	}
}
