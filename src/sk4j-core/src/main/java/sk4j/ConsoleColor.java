package sk4j;

/**
 * 
 * @author jcruz
 *
 */
public enum ConsoleColor {
	WHITE("\033[0m"), BLUE("\033[94m"), YELLOW("\033[33m"), MAGENTA("\033[95m"), CYAN("\033[96m"), RED("\033[91m"), GRAY("\033[90m"), GREEN("\033[32m"), BOLD("\033[1m");

	String value;

	ConsoleColor(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
