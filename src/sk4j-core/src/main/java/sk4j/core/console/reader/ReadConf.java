package sk4j.core.console.reader;

import sk4j.core.console.ConsoleValidator;
import sk4j.core.console.validator.ConsoleAlphaValidator;
import sk4j.core.console.validator.ConsoleAlphanumericValidator;
import sk4j.core.console.validator.ConsoleJavaClassNameValidator;
import sk4j.core.console.validator.ConsoleNumberValidator;
import sk4j.core.console.validator.ConsoleSkProjectNameValidator;
import sk4j.core.console.validator.ConsoleYesNoValidator;

/**
 * 
 * @author jcruz
 *
 */
public enum ReadConf {
	//
	ALPHANUMERIC(ConsoleAlphanumericValidator.class),
	//
	ALPHA(ConsoleAlphaValidator.class),
	//
	SK_PROJECT_NAME(ConsoleSkProjectNameValidator.class),
	//
	NUMBER(ConsoleNumberValidator.class),
	//
	JAVA_CLASS_NAME(ConsoleJavaClassNameValidator.class),
	//
	YES_NO(ConsoleYesNoValidator.class);

	private Class<? extends ConsoleValidator> validator;

	private ReadConf(Class<? extends ConsoleValidator> validator) {
		this.validator = validator;
	}

	public Class<? extends ConsoleValidator> getValidator() {
		return validator;
	}
}
