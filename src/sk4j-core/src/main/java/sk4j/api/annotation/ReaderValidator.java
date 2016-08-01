package sk4j.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import sk4j.api.ConsoleReaderValidator;

@Retention(RUNTIME)
@Target(FIELD)
public @interface ReaderValidator {
	Class<? extends ConsoleReaderValidator> value();
}
