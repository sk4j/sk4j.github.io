package sk4j.validator.custom;

import java.util.regex.Pattern;

import sk4j.validator.ReaderValidator;
import sk4j.validator.annotation.ReaderValidatorConf;

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
@ReaderValidatorConf(messageOnFail = "A entrada de dados deve ser um nome de classe java válido")
public class ReaderJavaClassNameValidator implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pattern javaClassNamePattern = Pattern.compile("^[A-Z_$][a-zA-Z\\d_$]*");

	@Override
	public boolean test(String t) {
		return javaClassNamePattern.matcher(t).matches();
	}

}
