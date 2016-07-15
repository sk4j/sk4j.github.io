package sk4j.core.console.validator;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.console.ConsoleValidator;

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
		return "";
	}

}
