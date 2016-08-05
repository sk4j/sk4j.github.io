package sk4j.input.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Configurações do leitor.
 * 
 * @author jcruz
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface NameableConf {

	String defaultValue() default "";

	boolean ignoreContext() default false;

}
