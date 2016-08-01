package sk4j.exception;

import sk4j.core.Console;

/**
 * Exception lançada quando os métodos {@link Console#readOption(String, java.util.List)} ou
 * {@link Console#readOptions(String, java.util.List)} possuem uma lista vazia como parâmetro.
 * 
 * @author jcruz
 *
 */
public class EmptyOptionParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyOptionParamException(String message) {
		super(message);
	}

}
