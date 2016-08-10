package sk4j.exception;

public class EmptyOptionParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyOptionParamException() {
		super();
	}

	public EmptyOptionParamException(String message) {
		super(message);
	}

}
