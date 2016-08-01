package sk4j.api;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import sk4j.api.reader.ReaderValidatorType;
import sk4j.console.Choosable;
import sk4j.console.reader.YesNoOption;

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
	String read(String label, ReaderValidatorType conf);

	/**
	 * @param label
	 * @param defaultValue
	 * @param conf
	 * @return String com valor de entrada.
	 */
	String read(String label, String defaultValue, ReaderValidatorType conf);

	/**
	 * 
	 * @param label
	 * @return Item (YES/NO) do Enum YesNoOption
	 */
	YesNoOption readYesNo(String label);

	/**
	 * 
	 * @param label
	 * @param defaultValue
	 * @return Item (YES/NO) do Enum YesNoOption
	 */
	YesNoOption readYesNo(String label, YesNoOption defaultValue);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return Elemento selecionado.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Choosable<T>> T readOption(String label, List<T> options);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return Lista de elementos selecionados.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Choosable<T>> List<T> readOptions(String label, List<T> options);

	/**
	 * 
	 * @param message
	 */
	void exit(String message);

}
