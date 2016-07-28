package sk4j.api;

import java.io.Serializable;
import java.util.Map;

import sk4j.impl.model.EJavaProjectImpl;

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

	/**
	 * 
	 * @param project
	 */
	void setProject(EJavaProjectImpl project);

	/**
	 * 
	 * @return
	 */
	EJavaProjectImpl getJavaProject();

	/**
	 * 
	 * @param value
	 * @return
	 */
	String replace(String value);
}
