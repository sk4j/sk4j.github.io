package sk4j.input.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Configurações do executor.
 * 
 * @author jcruz
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface ExecutableConf {

	/**
	 * Order de visualização no console.
	 * 
	 * @return
	 */
	int order();

	/**
	 * 
	 * @return
	 */
	String message();
}
