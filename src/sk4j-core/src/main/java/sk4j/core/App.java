package sk4j.core;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.text.StrSubstitutor;

import sk4j.api.Context;

/**
 * 
 * @author jcruz
 *
 */
public class App implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

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

}
