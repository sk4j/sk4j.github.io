package sk4j.core.input;

public class StringChooser implements Choosable<StringChooser> {

	private String value;

	public StringChooser(String value) {
		super();
		this.value = value;
	}

	@Override
	public int compareTo(StringChooser o) {
		return this.value.compareTo(o.getValue());
	}

	@Override
	public String getChoiseLabel() {
		return this.value;
	}

	public String getValue() {
		return value;
	}

}
