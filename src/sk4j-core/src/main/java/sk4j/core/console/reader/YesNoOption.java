package sk4j.core.console.reader;

public enum YesNoOption {
	YES("y"), NO("n");

	private String value;

	private YesNoOption(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static YesNoOption getOption(String opt) {
		if (opt.equalsIgnoreCase("y")) {
			return YesNoOption.YES;
		}
		return YesNoOption.NO;
	}

}
