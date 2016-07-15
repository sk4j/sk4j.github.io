package sk4j.core.console.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.console.ConsoleColor;
import sk4j.core.console.ConsoleValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ConsoleAlphaValidator extends ConsoleValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return StringUtils.isAlpha(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return ConsoleColor.yellow("A entrada de dados deve conter apenas letras.");
	}

}
