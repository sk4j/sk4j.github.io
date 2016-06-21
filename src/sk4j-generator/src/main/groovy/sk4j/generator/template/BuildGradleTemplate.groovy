package sk4j.generator.template

import sk4j.SkTemplate

class BuildGradleTemplate extends SkTemplate {
	
	@Override
	String template() {
		'''
apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'groovy'

sourceCompatibility = 1.7
version = '1.0'


repositories { mavenCentral() }

dependencies {
	compile group: 'commons-collections', name: 'commons-collections', version: '3.2'
	compile 'org.codehaus.groovy:groovy-all:2.4.3'
	compile group: 'com.thoughtworks.qdox', name: 'qdox', version: '1.12.1'
	compile group: 'org.jboss.forge.roaster', name: 'roaster-jdt', version: '2.18.7.Final'
	compile group: 'commons-io', name: 'commons-io', version: '2.5'
	compile files("../../lib/sk4j-core-1.0.jar")
	testCompile group: 'junit', name: 'junit', version: '4.12'
}

test { systemProperties 'property': 'value' }


jar {
	manifest {
		attributes 'Implementation-Title': '${context.projectName}',
		'Implementation-Version': version,
		'Main-Class' : 'sk4j.generator.AppGenerator',
		'Class-Path': configurations.compile.collect {File file -> "./../lib/\\${file.name}"}.join(" ")
	}
	archiveName = "\\${baseName}.jar"
}


task pack(dependsOn: build) << {
	copy {
		from configurations.compile.filter { File file -> !file.name.startsWith('sk4j-core') }
		into '../../lib'
	}
	copy {
		from "build/libs/${context.projectName}.jar"
		into '../../artifact'
	}
}
'''
	}
	
}
