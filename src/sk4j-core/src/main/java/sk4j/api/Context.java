package sk4j.api;

import java.io.Serializable;

public interface Context extends Serializable {

	void put(String key, Object value);
	
	Object get(String key);
}
