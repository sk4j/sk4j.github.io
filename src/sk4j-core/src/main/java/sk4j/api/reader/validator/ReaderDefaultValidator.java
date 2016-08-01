package sk4j.api.reader.validator;

import sk4j.api.ConsoleReaderValidator;

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
