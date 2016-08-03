package sk4j.input.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ExecutorConf {
	/**
	 * Mensagem exibida no console orientando a entrada do usuário.
	 * 
	 * @return Mensagem de entrada.
	 */
	String message() default "Digite o numero da opção";
}