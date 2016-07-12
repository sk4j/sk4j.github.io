package sk4j.core;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.text.StrSubstitutor;

import sk4j.api.Console;
import sk4j.api.Context;

/**
 * 
 * @author jcruz
 *
 */
public class SkApp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Console console;

	/**
	 * 
	 * Formata a String de entrada com as informações do contexto.
	 * 
	 * @param value
	 * @return
	 */
	protected String format(String value) {
		StrSubstitutor substitutor = new StrSubstitutor(context.get());
		return substitutor.replace(value);
	}

	/**
	 * 
	 * Sai da aplicação dada uma condição e exibindo uma mensagem de saída.
	 * 
	 * @param condition
	 * @param messageOnFail
	 */
	protected void quit(boolean condition, String messageOnFail) {
		if (condition) {
			console.exit(messageOnFail);
		}
	}

}
