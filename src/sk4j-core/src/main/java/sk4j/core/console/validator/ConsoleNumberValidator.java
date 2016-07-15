package sk4j.core.console.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.console.ConsoleValidator;

/**
 * Verifica se a String contem apenas números.
 * 
 * @author jcruz
 *
 */
public class ConsoleNumberValidator extends ConsoleValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return StringUtils.isNumeric(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return "";
	}

}
