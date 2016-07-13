package sk4j.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.api.Context;

/**
 * 
 * Classe utilitária para manipulação de Strings.
 * 
 * Disponível dentro de templates .jtwig com o alias 'st'.
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
	 * @param value
	 * @return
	 */
	public boolean isEmpty(String str) {
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
