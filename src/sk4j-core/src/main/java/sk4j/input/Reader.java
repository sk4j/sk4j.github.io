package sk4j.input;

import java.io.IOException;
import java.io.Serializable;

/**
 * Leitor de texto do console.
 * 
 * @author jcruz
 *
 */
public interface Reader extends Serializable {

	/**
	 * Retorna o texto do console.
	 * 
	 * @return Texto do console.
	 * @throws IOException
	 */
	String read() throws IOException;

}
