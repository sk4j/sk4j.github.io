package sk4j.api.reader.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.api.ConsoleReaderValidator;
import sk4j.console.ConsoleColor;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderAlphaValidator extends ConsoleReaderValidator {

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
