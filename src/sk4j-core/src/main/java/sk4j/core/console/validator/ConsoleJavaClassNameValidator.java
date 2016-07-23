package sk4j.core.console.validator;

import java.util.regex.Pattern;

import sk4j.core.console.ConsoleColor;
import sk4j.core.console.ConsoleValidator;

/**
 * Verifica se a String está de acordo com um nome de classe java padrão. Padrão de nome de classe java:
 * 
 * <pre>
 * 	<ol>
 * 		<li>Primeira letra em caixa alta</li>
 * 		<li>Sem whitespace no nome</li>
 * 	</ol>
 * </pre>
 * 
 * @author jcruz
 *
 */
public class ConsoleJavaClassNameValidator extends ConsoleValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pattern javaClassNamePattern = Pattern.compile("^[A-Z_$][a-zA-Z\\d_$]*");

	@Override
	protected boolean test(String t) {
		return javaClassNamePattern.matcher(t).matches();
	}

	@Override
	protected String consoleMessageOnFalse() {
		return ConsoleColor.yellow("A entrada de dados deve ser um nome de classe java válido.");
	}

}
