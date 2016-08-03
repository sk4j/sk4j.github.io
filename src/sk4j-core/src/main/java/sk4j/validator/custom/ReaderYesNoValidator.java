package sk4j.validator.custom;

import java.util.Arrays;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

/**
 * 
 * @author jcruz
 *
 */
@ReaderValidatorConf(messageOnFail = "Entrada inválida. A entrada de dados deve ser y para sim ou n para não.")
public class ReaderYesNoValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean test(String t) {
		return Arrays.asList("n", "N", "Y", "y").contains(t);
	}

}
