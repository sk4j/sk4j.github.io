package sk4j.model

import groovy.io.FileType

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

import org.apache.commons.io.FilenameUtils
import org.w3c.dom.Document

import sk4j.SkConsole

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

	/**
	 * 
	 */
	List<File> files

	/**
	 * 
	 */
	List<EXmlFile> xmlFiles

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
					try {
						JavaDocBuilder builder = new JavaDocBuilder()
						JavaSource source = builder.addSource(it)
						def path =  FilenameUtils.normalize(FilenameUtils.getFullPath(it.absolutePath))
						this.javaFiles << new EJavaFile(javaClass: source.classes[0], path: path)
					} catch (Exception e) {
						new SkConsole().log "Erro ao processar classe ${it.name}"
					}
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
			file.eachFileRecurse(FileType.DIRECTORIES) { File dir ->
				if(!dir.hidden) {
					dirs << dir
				}
			}
		}
		return dirs
	}

	/**
	 * Itera por todos os arquivos do projeto.
	 * @return
	 */
	public List<File> getFiles() {
		if(this.files == null) {
			this.files = []
			file.eachFileRecurse(FileType.FILES) { File file -> files << file }
		}
		return files
	}

	public List<EXmlFile> getXmlFiles() {
		if(xmlFiles == null) {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance()
			DocumentBuilder builder = factory.newDocumentBuilder()
			this.xmlFiles = []
			file.eachFileRecurse(FileType.FILES) { File file ->
				if(file.absolutePath.endsWith('.xhtml')) {
					println file.absoluteFile
					Document document = builder.parse(file.absolutePath)
					this.xmlFiles << new EXmlFile(path: file.absolutePath, name:file.name, doc: document)
				}
			}
		}
		return xmlFiles
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

	@Override
	public String toString() {
		return "EProject [path=" + path + "]";
	}
	
}
