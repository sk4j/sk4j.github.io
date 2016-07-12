package sk4j.core;

import org.apache.commons.lang3.text.StrSubstitutor;

/**
 * 
 * @author jcruz
 *
 */
public class SkApp {

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected String format(String value) {
		StrSubstitutor substitutor = new StrSubstitutor(SkContext.get().getContext());
		return substitutor.replace(value);
	}

	/**
	 * 
	 * @param condition
	 * @param messageOnFail
	 */
	protected void quit(boolean condition, String messageOnFail) {
		if (condition) {
			SkSystem.exit(messageOnFail);
		}
	}

}
