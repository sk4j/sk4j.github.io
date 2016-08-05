package sk4j.input.api;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface Nameable<T> extends Serializable {

	public T getValue();

	public void setValue(T string);

}
