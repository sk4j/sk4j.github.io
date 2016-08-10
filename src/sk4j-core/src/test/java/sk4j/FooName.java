package sk4j;

import org.hibernate.validator.constraints.NotBlank;

import sk4j.input.Name;

public class FooName extends Name {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@NotBlank
	public String getValue() {
		return super.getValue();
	}

}
