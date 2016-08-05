package sk4j.input.api;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface Nameable extends Serializable {

	public String getValue();

	public void setValue(String string);

}
