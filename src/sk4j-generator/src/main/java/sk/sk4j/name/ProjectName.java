package sk.sk4j.name;

import org.hibernate.validator.constraints.NotBlank;

import sk4j.input.Name;

public class ProjectName extends Name {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@NotBlank(message = "O nome do projeto não pode ser em branco.")
	public String getValue() {
		return super.getValue();
	}

}
