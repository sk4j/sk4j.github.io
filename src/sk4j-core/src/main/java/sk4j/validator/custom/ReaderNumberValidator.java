package sk4j.validator.custom;

import org.apache.commons.lang3.StringUtils;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

/**
 * Verifica se a String contem apenas números.
 * 
 * @author jcruz
 *
 */
@ReaderValidatorConf(messageOnFail = "A entrada de dados deve conter apenas números.")
public class ReaderNumberValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean test(String t) {
		return StringUtils.isNumeric(t);
	}

}
