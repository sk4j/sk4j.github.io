package sk4j.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.Colorize;
import sk4j.core.ConsoleReaderValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderAlphanumericValidator extends ConsoleReaderValidator {

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
		return Colorize.yellow("A entrada de dados deve conter letras ou números.");
	}

}
