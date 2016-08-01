package sk4j.validator;

import java.util.Arrays;

import sk4j.console.ConsoleColor;
import sk4j.core.ConsoleReaderValidator;

/**
 * 
 * @author jcruz
 *
 */
public class ReaderYesNoValidator extends ConsoleReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean test(String t) {
		return Arrays.asList("n", "N", "Y", "y").contains(t);
	}

	@Override
	protected String consoleMessageOnFalse() {
		return ConsoleColor.yellow("Entrada inválida. A entrada de dados deve ser y para sim ou n para não.");
	}

}
