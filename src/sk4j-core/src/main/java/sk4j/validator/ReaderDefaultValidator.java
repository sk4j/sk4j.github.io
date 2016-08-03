package sk4j.validator;

import sk4j.core.ReaderValidator;

public class ReaderDefaultValidator extends ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return true;
	}

	@Override
	protected String consoleMessageOnFalse() {
		return null;
	}

}
