package sk4j.core.console.validator;

import java.util.Arrays;

import sk4j.core.console.ConsoleValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ConsoleYesNoValidator extends ConsoleValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return Arrays.asList("n", "N", "Y", "y").contains(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return "";
	}

}
