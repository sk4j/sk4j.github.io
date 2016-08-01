package sk4j.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import sk4j.console.Selectable;

/**
 * Classe responsável trabalhar com o Console.
 * 
 * @author jcruz
 *
 */
public interface Console extends Serializable {

	/**
	 * 
	 * @param label
	 * @return String com valor de entrada.
	 * @throws IOException
	 */
	String read(String label);

	/**
	 * 
	 * @param label
	 * @param defaultValue
	 * @return String com valor de entrada.
	 */
	String read(String label, String defaultValue);

	/**
	 * 
	 * @param label
	 * @param conf
	 * @return String com valor de entrada.
	 */
	// String read(String label, ReaderValidatorType conf);

	/**
	 * @param label
	 * @param defaultValue
	 * @param conf
	 * @return String com valor de entrada.
	 */
	// String read(String label, String defaultValue, ReaderValidatorType conf);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return Elemento selecionado.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Selectable<T>> T readOption(String label, List<T> options);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return Lista de elementos selecionados.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Selectable<T>> List<T> readOptions(String label, List<T> options);

	/**
	 * 
	 * @param message
	 */
	void exit(String message);

}
