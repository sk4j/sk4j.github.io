package sk4j.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.api.Context;

/**
 * 
 * Classe utilitária para manipulação de Strings.A classe está disponivel dentro de templates .jtwig com o alias 'st'.
 * 
 * @author jcruz
 *
 */
public class StringTool implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context ctx;

	/**
	 * 
	 * Verifica se a String é whitespace, vazia ("") ou null.
	 * 
	 * <pre>
	 * st.isBlank(null) = true 
	 * st.isBlank("") = true 
	 * st.isBlank(" ") = true 
	 * st.isBlank("bob") = false 
	 * st.isBlank(" bob ") = false
	 * </pre>
	 * 
	 * @param str
	 *            String a ser verificada.
	 * @return {@code true} se a String for whitespace, vazia ("") ou null.
	 * 
	 * 
	 */
	public boolean isBlank(String str) {
		return StringUtils.isBlank(ctx.replace(str));
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean containsWhitespace(String str) {
		return StringUtils.containsWhitespace(ctx.replace(str));
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	//@formatter:off
	public String camelize(String str) {
		return Arrays.asList(StringUtils.split(ctx.replace(str), "_-"))
					.stream()
					.map(StringUtils::capitalize)
					.collect(Collectors.joining());
	}
	//@formatter:on

	/**
	 * 
	 * Substitui o undercore pelo traço.
	 * 
	 * @param str
	 * @return
	 */
	public String dasherize(String str) {
		return StringUtils.join(StringUtils.split(ctx.replace(str), "_"), "-");
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public String underscore(String str) {
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(ctx.replace(str)), "_").toLowerCase();
	}

}
