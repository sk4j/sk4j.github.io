package sk4j.console.reader;

import sk4j.console.ConsoleValidator;
import sk4j.console.validator.ConsoleAlphaValidator;
import sk4j.console.validator.ConsoleAlphanumericSpaceValidator;
import sk4j.console.validator.ConsoleAlphanumericValidator;
import sk4j.console.validator.ConsoleJavaClassNameValidator;
import sk4j.console.validator.ConsoleNumberValidator;
import sk4j.console.validator.ConsoleSkProjectNameValidator;
import sk4j.console.validator.ConsoleYesNoValidator;

/**
 * 
 * @author jcruz
 *
 */
public enum ReadConf {
	//
	ALPHANUMERIC(ConsoleAlphanumericValidator.class),
	//
	ALPHANUMERIC_SPACE(ConsoleAlphanumericSpaceValidator.class),
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
