package sk4j.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface SelectorConf {
	/**
	 * Mensagem exibida no console orientando a entrada do usuário.
	 * 
	 * @return Mensagem de entrada.
	 */
	String message() default "Digite o número da opção";
}
