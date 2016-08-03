package sk4j.validator.custom;

import java.util.regex.Pattern;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

/**
 * 
 * @author jcruz
 *
 */
@ReaderValidatorConf(messageOnFail = "O nome do projeto não pode possuir letras em caixa alta, espaços ou números. Use o traço para separar as palavras.")
public class ReaderSkProjectNameValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pattern pattern = Pattern.compile("^[a-z]+(-[a-z]+)*");

	@Override
	public boolean test(String t) {
		return pattern.matcher(t).matches();
	}

}
