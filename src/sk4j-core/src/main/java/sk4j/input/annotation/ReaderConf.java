package sk4j.input.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Configuração do leitor de opções.
 * 
 * @author jcruz
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface ReaderConf {

	/**
	 * Mensagem exibida no console orientando a entrada do usuário.
	 * 
	 * @return Mensagem de entrada.
	 */
	String message();
}
