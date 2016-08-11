package sk4j.template;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface Template extends Serializable {

	String merge(String templateName);

	void mergeAndCreateFile(String templateName, String path);
}
