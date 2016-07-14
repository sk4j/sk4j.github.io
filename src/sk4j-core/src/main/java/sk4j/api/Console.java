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

	public enum ConsoleConf {
		ALPHANUMERIC, NUMBER, JAVACLASSNAME
	}

	public enum YesNoOption {
		YES, NO
	}

	/**
	 * 
	 * @param label
	 * @return
	 */
	YesNoOption readYesNo(String label);

	/**
	 * 
	 * @param label
	 * @param defaultValue
	 * @return
	 */
	YesNoOption readYesNO(String label, YesNoOption defaultValue);

	/**
	 * 
	 * @param label
	 * @return
	 * @throws IOException
	 */
	String readln(String label);

	/**
	 * 
	 * @param label
	 * @param defaultValue
	 * @return
	 */
	String readln(String label, String defaultValue);

	/**
	 * 
	 * @param label
	 * @param conf
	 * @return
	 */
	String readln(String label, ConsoleConf conf);

	/**
	 * @param label
	 * @param defaultValue
	 * @param conf
	 * @return
	 */
	String readln(String label, String defaultValue, ConsoleConf conf);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	<T extends Choosable<T>> T readOption(String label, List<T> options);

	/**
	 * 
	 * @param label
	 * @param options
	 * @return
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
