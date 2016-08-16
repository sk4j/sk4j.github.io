package sk.sk4j.name;

import org.hibernate.validator.constraints.NotEmpty;

import sk4j.input.Name;

public class ProjectDesc extends Name {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@NotEmpty
	public String getValue() {
		return super.getValue();
	}

}
