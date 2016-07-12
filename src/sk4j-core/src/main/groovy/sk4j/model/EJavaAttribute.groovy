package sk4j.model

import sk4j.input.Choosable

import com.thoughtworks.qdox.model.Annotation
import com.thoughtworks.qdox.model.JavaField

/**
 * 
 * @author jcruz
 *
 */
class EJavaAttribute extends EModel<EJavaAttribute> implements Choosable<EJavaAttribute>   {
	
	String name
	/**
	 * 
	 */
	JavaField javaField
	
	
	public String getName() {
		if(this.name == null) {
			this.name = javaField.name
		}
		return name;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	boolean hasAnnotation(String name) {
		this.annotations.any { Annotation ann -> ann.type.value.endsWith(name) }
	}
	
	/**
	 * 
	 */
	@Override
	public int compareTo(EJavaAttribute o) {
		return this.javaField.name.compareTo(o.javaField.name)
	}
	
	/**
	 * 
	 */
	@Override
	public String getChoiseLabel() {
		def greenColor = ConsoleColor.GREEN.value
		def whiteColor = ConsoleColor.WHITE.value
		def bold = ConsoleColor.BOLD.value
		return "${bold}${javaField.name}${whiteColor} : ${greenColor}${javaField.type}${whiteColor}"
	}

	@Override
	public String toString() {
		return "EJavaAttribute [name=" + name + "]";
	}
	
}
