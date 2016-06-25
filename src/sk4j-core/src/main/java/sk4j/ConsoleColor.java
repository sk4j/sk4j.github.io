package sk4j;

public enum ConsoleColor {
	WHITE("\033[0m"), BLUE("\033[94m"), YELLOW("\033[33m"), MAGENTA("\033[95m"), CYAN("\033[96m"), RED("\033[91m"), GRAY("\033[90m");

	String value;

	ConsoleColor(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
