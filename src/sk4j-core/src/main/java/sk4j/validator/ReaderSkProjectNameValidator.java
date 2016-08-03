package sk4j.validator;

import java.util.regex.Pattern;

import sk4j.console.Colorize;
import sk4j.core.ReaderValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderSkProjectNameValidator extends ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pattern pattern = Pattern.compile("^[a-z]+(-[a-z]+)*");

	@Override
	protected boolean test(String t) {
		return pattern.matcher(t).matches();
	}

	@Override
	protected String consoleMessageOnFalse() {
		return Colorize.yellow(
				"O nome do projeto não pode possuir letras em caixa alta, espaços ou números. Use o traço para separar as palavras.");
	}

}
