package sk4j.api;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface Template extends Serializable {

	String merge(String templateName);
}
