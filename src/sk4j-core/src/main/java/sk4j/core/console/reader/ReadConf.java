package sk4j.core.console.reader;

import sk4j.core.console.ConsoleValidator;
import sk4j.core.console.validator.ConsoleAlphanumericValidator;
import sk4j.core.console.validator.ConsoleJavaClassNameValidator;
import sk4j.core.console.validator.ConsoleNumberValidator;

/**
 * 
 * @author jcruz
 *
 */
public enum ReadConf {
	//
	ALPHANUMERIC(ConsoleAlphanumericValidator.class),
	//
	NUMBER(ConsoleNumberValidator.class),
	//
	JAVACLASSNAME(ConsoleJavaClassNameValidator.class);

	private Class<? extends ConsoleValidator> validator;

	private ReadConf(Class<? extends ConsoleValidator> validator) {
		this.validator = validator;
	}

	public Class<? extends ConsoleValidator> getValidator() {
		return validator;
	}
}
