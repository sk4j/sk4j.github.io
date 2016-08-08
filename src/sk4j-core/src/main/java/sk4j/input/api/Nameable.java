package sk4j.input.api;

import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import sk4j.console.Colorize;

/**
 * 
 * @author jcruz
 *
 */
public interface Nameable<T> extends Serializable {

	public T getValue();

	public void setValue(T string);

	default boolean validate() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Nameable<T>>> violations = validator.validate(this);
		violations.stream().forEach(p -> System.out.println(Colorize.yellow(p.getMessage())));
		return violations.size() > 0;
	}

}
