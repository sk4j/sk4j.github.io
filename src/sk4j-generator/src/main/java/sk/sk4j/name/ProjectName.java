package sk.sk4j.name;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import sk4j.input.Name;

public class ProjectName extends Name {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@NotBlank(message = "O nome do projeto não pode ser em branco.")
	@Pattern.List(value = {
			@Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "O nome do projeto não pode conter espaços ou iniciar com número, hifen ou traço.") })
	public String getValue() {
		return super.getValue();
	}

}
