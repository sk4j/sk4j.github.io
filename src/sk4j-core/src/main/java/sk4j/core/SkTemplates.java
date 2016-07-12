package sk4j.core;

/**
 * 
 * @author jcruz
 *
 */
public class SkTemplates {

	public static SkTemplate get(String templateName) {
		return new SkTemplate(templateName);
	}

}
