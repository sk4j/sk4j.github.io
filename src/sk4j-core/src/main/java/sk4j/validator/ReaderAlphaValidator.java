package sk4j.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.Colorize;
import sk4j.core.ReaderValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderAlphaValidator extends ReaderValidator {

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
		return Colorize.yellow("A entrada de dados deve conter apenas letras.");
	}

}
