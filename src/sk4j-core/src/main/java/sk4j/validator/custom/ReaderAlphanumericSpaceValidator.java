package sk4j.validator.custom;

import org.apache.commons.lang3.StringUtils;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

/**
 * 
 * @author jcruz
 *
 */
@ReaderValidatorConf(messageOnFail = "A entrada de dados deve conter apenas letras, números ou espaços entre palavras.")
public class ReaderAlphanumericSpaceValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean test(String t) {
		return StringUtils.isAlphanumericSpace(t) && StringUtils.isNotBlank(t);
	}

}
