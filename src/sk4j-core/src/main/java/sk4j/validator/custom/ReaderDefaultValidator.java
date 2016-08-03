package sk4j.validator.custom;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

@ReaderValidatorConf(messageOnFail = "")
public class ReaderDefaultValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean test(String t) {
		return true;
	}

}
