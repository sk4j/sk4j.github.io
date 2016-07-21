package sk4j.core.chooser;

import sk4j.core.console.Choosable;

public class StringChooser implements Choosable<StringChooser> {

	private String value;

	private Integer id;

	public StringChooser(Integer id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	@Override
	public int compareTo(StringChooser o) {
		return this.id.compareTo(o.id);
	}

	@Override
	public String getChoiseLabel() {
		return this.value;
	}

	public String getValue() {
		return value;
	}

	public Integer getId() {
		return id;
	}

}
