package sk4j.input.api;

import java.io.IOException;
import java.io.Serializable;

/**
 * Leitor de string do console.
 * 
 * @author jcruz
 *
 */
public interface Reader extends Serializable {

	<T extends Name> void read(String message, T name) throws IOException;

	<T extends Name> void read(String message, String contextKey, T name) throws IOException;
}
