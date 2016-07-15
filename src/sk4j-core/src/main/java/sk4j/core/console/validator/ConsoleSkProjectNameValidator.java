package sk4j.core.console.validator;

import java.util.regex.Pattern;

import sk4j.core.console.ConsoleColor;
import sk4j.core.console.ConsoleValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ConsoleSkProjectNameValidator extends ConsoleValidator {

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
		return ConsoleColor.yellow(
				"O nome do projeto não pode possuir letras em caixa alta, espaços ou números. Use o traço para separar as palavras.");
	}

}
