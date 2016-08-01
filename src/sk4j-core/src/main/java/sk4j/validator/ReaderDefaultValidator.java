package sk4j.validator;

import sk4j.core.ConsoleReaderValidator;

public class ReaderDefaultValidator extends ConsoleReaderValidator {

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
