package sk4j.model

import groovy.io.FileType

import org.apache.commons.io.FilenameUtils

import com.thoughtworks.qdox.JavaDocBuilder
import com.thoughtworks.qdox.model.JavaSource

/**
 * 
 * @author jcruz
 *
 */
class EProject {

	/**
	 * 
	 */
	String name
	/**
	 * 
	 */
	String path

	/**
	 * 
	 */
	File file

	/**
	 * 
	 */
	List<EJavaFile> javaFiles

	/**
	 * 
	 */
	List<File> dirs

	public EProject() {
		super()
	}

	/**
	 * 
	 * Iterar pelos diretórios do projeto e identifica todos os arquivos do tipo java. 
	 * 
	 * @return
	 */
	public List<EJavaFile> getJavaFiles() {
		if(javaFiles == null) {
			this.javaFiles = []
			file.eachFileRecurse(FileType.FILES) {
				if(it.name.endsWith('.java')) {
					JavaDocBuilder builder = new JavaDocBuilder()
					JavaSource source = builder.addSource(it)
					def path =  FilenameUtils.normalize(FilenameUtils.getFullPath(it.absolutePath))
					this.javaFiles << new EJavaFile(javaClass: source.classes[0], path: path)
				}
			}
		}
		return this.javaFiles
	}

	/**
	 * Itera por todos os diretórios do projeto.
	 * 
	 * @return
	 */
	public List<File> getDirs() {
		if(this.dirs == null) {
			this.dirs = []
			file.eachFileRecurse(FileType.DIRECTORIES) { dirs << it }
		}
		return dirs
	}

	/**
	 * Verifica se o projeto possui o arquivo pom.xml (Maven Project)
	 * 
	 * @return 
	 */
	boolean isMavenProject() {
		new File("${path}/pom.xml").exists()
	}

	/**
	 * Verifica se o projeto possui o arquivo build.gradle (Gradle Project)	
	 * 
	 * @return
	 */
	boolean isGradleProject() {
		new File("${path}/build.gradle").exists()
	}
	
	/**
	 * 
	 * @param javaFileName
	 * @return
	 */
	boolean hasJavaFile(String javaFileName) {
		getJavaFiles().any { it.javaClass.name.equals(javaFileName) }
	}
}
