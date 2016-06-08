package sk4j.model

import org.jboss.forge.roaster.model.source.JavaClassSource

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

	JavaClass javaClass

	/**
	 * 
	 */
	JavaClassSource javaClassSource

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
		this.javaClass.name
	}
}
