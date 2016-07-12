package sk4j.api;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import sk4j.core.exception.InvalidOptionException;
import sk4j.core.input.Choosable;

/**
 * Classe responsável trabalhar com o Console.
 * 
 * @author jcruz
 *
 */
public interface Console extends Serializable {

	/**
	 * 
	 * @return
	 */
	void echo(String message);

	/**
	 * 
	 * @param label
	 * @return
	 * @throws IOException
	 */
	String readln(String label) throws IOException;

	/**
	 * 
	 * @param label
	 * @param options
	 * @return
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Choosable<T>> T readOption(String label, List<T> options) throws IOException, InvalidOptionException;

	/**
	 * 
	 * @param label
	 * @param options
	 * @return
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Choosable<T>> List<T> readOptions(String label, List<T> options) throws IOException, InvalidOptionException;
}
