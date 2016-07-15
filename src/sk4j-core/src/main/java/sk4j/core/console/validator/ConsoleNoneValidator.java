package sk4j.core.console.validator;

import sk4j.core.console.ConsoleValidator;

public class ConsoleNoneValidator extends ConsoleValidator {

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
		return "";
	}

}
