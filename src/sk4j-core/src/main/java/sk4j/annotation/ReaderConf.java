package sk4j.annotation;

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
public @interface ReaderConf {
	/**
	 * Mensagem exibida no console orientando a entrada do usuário.
	 * 
	 * @return Mensagem de entrada.
	 */
	String message() default "Digite";

	/**
	 * Id da variável de contexto que irá armazenar os dados de entrada.
	 * 
	 * @return Id de contexto.
	 */
	String contextKey() default "";
}
