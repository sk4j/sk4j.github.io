package sk4j.template;

import java.io.IOException;
import java.io.Serializable;

import sk4j.model.EPath;

/**
 * 
 * @author jcruz
 *
 */
public interface Template extends Serializable {

	/**
	 * 
	 * @param templateName
	 * @return
	 */
	String merge(String templateName);

	/**
	 * 
	 * @param templateName
	 * @param path
	 * @throws IOException
	 */
	void mergeAndCreateFile(String templateName, EPath epath) throws IOException;
}
