package sk4j.api;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author jcruz
 *
 */
public interface Context extends Serializable {

	/**
	 * 
	 * @param key
	 * @param value
	 */
	void putItem(String key, Object value);

	/**
	 * 
	 * @param key
	 * @return
	 */
	Object getItem(String key);

	/**
	 * 
	 * @return
	 */
	Map<String, Object> get();
}
