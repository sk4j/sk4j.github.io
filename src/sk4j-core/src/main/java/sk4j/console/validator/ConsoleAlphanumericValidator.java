package sk4j.console.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.ConsoleColor;
import sk4j.console.ConsoleValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ConsoleAlphanumericValidator extends ConsoleValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return StringUtils.isAlphanumeric(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return ConsoleColor.yellow("A entrada de dados deve conter letras ou números.");
	}

}
