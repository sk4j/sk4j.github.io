package sk4j.core.console;

public class CColor {
	/**
	 * Coloriza a String com a cor branca.
	 * 
	 * @param value
	 *            String a ser colorizada.
	 * @return String colorizada.
	 */
	public static String white(String value) {
		return String.format("\033[0m%s\033[0m", value);
	}

	/**
	 * Coloriza a String com a cor azul.
	 * 
	 * @param value
	 * @return
	 */
	public static String blue(String value) {
		return String.format("\033[94m%s\033[0m", value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String yellow(String value) {
		return String.format("\033[33m%s\033[0m", value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String magenta(String value) {
		return String.format("\033[95m%s\033[0m", value);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String cyan(String value) {
		return String.format("\033[96m%s\033[0m", value);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String red(String value) {
		return String.format("\033[91m%s\033[0m", value);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String gray(String value) {
		return String.format("\033[90m%s\033[0m", value);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String green(String value) {
		return String.format("\033[32m%s\033[0m", value);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String bold(String value) {
		return String.format("\033[1m%s\033[0m", value);
	}
}
