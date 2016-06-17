package foo

import sk4j.SkApp
import sk4j.model.EJavaFile
import sk4j.model.EProject

class ProjectApp extends SkApp {

	static main(args) {
		println System.getProperty("user.dir")
		EProject project = new EProject(file: new File("/home/jcruz/Programs/eclipse-mars/workspace/aelis2016"))
		/*
		project.javaFiles.each { EJavaFile javaFile ->
			if(javaFile.hasAnnotation('Entity')) {
				String tmp = javaFile.merge(DaoTemplate) as String
				println tmp
			}
		}*/
		
		project.dirs.each { File dir ->
			println dir.name			
		}
	}

	@Override
	public void run() {
		
	}
	
	
}
