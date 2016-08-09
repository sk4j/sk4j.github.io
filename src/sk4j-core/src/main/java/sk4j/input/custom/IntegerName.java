package sk4j.input.custom;

import sk4j.core.Context;
import sk4j.input.api.Name;

public class IntegerName extends Name<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntegerName(Context context, String contextKey) {
		super(context, contextKey);
	}

	private Integer value;

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer asObject(String value) {
		return Integer.valueOf(value);
	}

	@Override
	public String asString(Integer nameable) {
		return String.valueOf(nameable);
	}

}
