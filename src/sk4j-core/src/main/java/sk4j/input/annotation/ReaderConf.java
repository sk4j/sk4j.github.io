package sk4j.input.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface ReaderConf {

	String message();

	String contextKey() default "";

	boolean ignoreContext() default false;

}
