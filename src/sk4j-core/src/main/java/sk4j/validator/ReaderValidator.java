package sk4j.validator;

import java.io.Serializable;
import java.util.function.Predicate;

import sk4j.validator.annotation.ReaderValidatorConf;

public interface ReaderValidator extends Predicate<String>, Serializable {

	default String getMessageOnFail() {
		if (this.getClass().isAnnotationPresent(ReaderValidatorConf.class)) {
			return this.getClass().getAnnotation(ReaderValidatorConf.class).messageOnFail();
		}
		return "";
	}
}
