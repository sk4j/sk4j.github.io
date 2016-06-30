package sk4j.model

import org.jboss.forge.roaster.Roaster
import org.jboss.forge.roaster.model.source.JavaClassSource

import sk4j.ConsoleColor
import sk4j.SkConsole
import sk4j.input.Choosable

import com.thoughtworks.qdox.model.Annotation
import com.thoughtworks.qdox.model.JavaClass

/**
 * 
 * @author jcruz
 *
 */
class EJavaFile extends EModel<EJavaFile> implements Choosable<EJavaFile>  {

	/**
	 * 
	 */
	String path

	/**
	 * 
	 */
	String name

	String parentPackageName

	JavaClass javaClass

	/**
	 * 
	 */
	//JavaClassSource javaClassSource

	/**
	 * 
	 */
	List<EJavaAttribute> javaAttributes

	/**
	 * 
	 */
	List<EJavaMethod> javaMethods

	/**
	 * 
	 * @return
	 */
	public String getName() {
		javaClass.name
	}

	public String getParentPackageName() {
		if(parentPackageName == null) {
			def packages = Arrays.asList(this.javaClass.package.name.split("\\."))
			this.parentPackageName = packages.dropRight(1).join(".")
		}
		return parentPackageName
	}

	public List<EJavaAttribute> getJavaAttributes() {
		if(javaAttributes == null) {
			this.javaAttributes = javaClass.fields.collect { new EJavaAttribute(javaField: it) }
		}
		return this.javaAttributes
	}

	public List<EJavaMethod> getJavaMethods() {
		if(this.javaMethods == null) {
			this.javaMethods = javaClass.methods.collect { new EJavaMethod(javaMethod: it)}
		}
		return this.javaMethods
	}

	/**
	 * Verifica se a classe possui a annotation especificada.
	 * @param name
	 * @return
	 */
	boolean hasAnnotation(String name) {
		javaClass.annotations.any { Annotation ann -> ann.type.value.endsWith(name) }
	}

	@Override
	public int compareTo(EJavaFile o) {
		this.javaClass.name.compareTo(o.javaClass.name)
	}

	@Override
	public String getChoiseLabel() {
		def greenColor = ConsoleColor.GREEN.value
		def whiteColor = ConsoleColor.WHITE.value
		def bold = ConsoleColor.BOLD.value
		"${bold}${this.javaClass.name}${whiteColor} - ${greenColor}${javaClass.packageName}${whiteColor}"
	}

	/**
	 * Atualiza o arquivo java via roaster.
	 * 
	 * @param c
	 * @return
	 */
	def update(Closure c) {
		SkConsole console = new SkConsole()
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value


		File javaFile = new File("${path}/${javaClass.name}.java")
		JavaClassSource jcs = Roaster.parse(JavaClassSource,javaFile)
		console.log "Iniciando atualização na classe ${javaFile.absolutePath}"
		c.call(jcs)
		FileWriter writer = new FileWriter(javaFile)
		writer.write(jcs.toString())
		writer.flush()
		writer.close()
		console.echo "${cyanColor}>>>${console.whiteColor} Classe atualizada:  ${javaFile.absolutePath}/${javaClass.name}.java"
	}

	@Override
	public String toString() {
		return "EJavaFile [path=" + path + "]";
	}
	
}
