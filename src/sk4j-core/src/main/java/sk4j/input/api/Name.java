package sk4j.input.api;

import java.io.Serializable;

public abstract class Name implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDefaultValue() {
		return null;
	}

}
