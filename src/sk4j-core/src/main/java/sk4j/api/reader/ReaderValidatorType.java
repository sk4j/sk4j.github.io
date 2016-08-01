package sk4j.api.reader;

import sk4j.api.ConsoleReaderValidator;
import sk4j.api.reader.validator.ReaderAlphaValidator;
import sk4j.api.reader.validator.ReaderAlphanumericSpaceValidator;
import sk4j.api.reader.validator.ReaderAlphanumericValidator;
import sk4j.api.reader.validator.ReaderJavaClassNameValidator;
import sk4j.api.reader.validator.ReaderNumberValidator;
import sk4j.api.reader.validator.ReaderSkProjectNameValidator;
import sk4j.api.reader.validator.ReaderYesNoValidator;

/**
 * 
 * @author jcruz
 *
 */
public enum ReaderValidatorType {
	//
	ALPHANUMERIC(ReaderAlphanumericValidator.class),
	//
	ALPHANUMERIC_SPACE(ReaderAlphanumericSpaceValidator.class),
	//
	ALPHA(ReaderAlphaValidator.class),
	//
	SK_PROJECT_NAME(ReaderSkProjectNameValidator.class),
	//
	NUMBER(ReaderNumberValidator.class),
	//
	JAVA_CLASS_NAME(ReaderJavaClassNameValidator.class),
	//
	YES_NO(ReaderYesNoValidator.class);

	private Class<? extends ConsoleReaderValidator> validator;

	private ReaderValidatorType(Class<? extends ConsoleReaderValidator> validator) {
		this.validator = validator;
	}

	public Class<? extends ConsoleReaderValidator> getValidator() {
		return validator;
	}
}
