package sk4j.core.console.validator;

import org.apache.commons.lang3.StringUtils;

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

	@Override
	protected boolean test(String t) {
		return StringUtils.isAllUpperCase(StringUtils.substring(t, 0, 1)) && StringUtils.isAlphanumeric(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return ConsoleColor.yellow("A entrada de dados deve ser um nome de classe java válido.");
	}

}
