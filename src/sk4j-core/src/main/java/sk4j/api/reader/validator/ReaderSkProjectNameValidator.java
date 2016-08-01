package sk4j.api.reader.validator;

import java.util.regex.Pattern;

import sk4j.api.ConsoleReaderValidator;
import sk4j.console.ConsoleColor;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderSkProjectNameValidator extends ConsoleReaderValidator {

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
