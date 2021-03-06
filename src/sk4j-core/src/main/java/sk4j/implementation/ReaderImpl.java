package sk4j.implementation;

import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.input.Name;
import sk4j.input.Reader;
import strman.Strman;

public class ReaderImpl implements Reader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	private String message;

	private String defaultValue;

	private String contextKey;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.input.Reader#read(java.lang.String, sk4j.input.Name)
	 */
	@Override
	public <T extends Name> T read(String message, T name) throws IOException {
		this.message = context.replace(message);
		this.defaultValue = context.replace(name.getDefaultValue());
		this.contextKey = Strman.toCamelCase(name.getClass().getSimpleName());
		String value = readConsole();
		name.setValue(value);
		if (validate(name)) {
			context.put(contextKey, name);
			return name;
		}
		return read(message, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.input.Reader#read(java.lang.String, java.lang.String, sk4j.input.Name)
	 */
	@Override
	public <T extends Name> void read(String message, String contextKey, T name) throws IOException {
		this.message = context.replace(message);
		this.defaultValue = context.replace(name.getDefaultValue());
		this.contextKey = contextKey;
		String value = readConsole();
		name.setValue(value);
		if (validate(name)) {
			context.put(contextKey, name);
			return;
		}
		read(message, name);
	}

	private String readConsole() throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		consoleReader.setHandleUserInterrupt(true);
		String value = consoleReader.readLine(getFormattedMessage());
		consoleReader.close();
		return StringUtils.isNotBlank(value) ? StringUtils.trim(value) : this.defaultValue;
	}

	private <T extends Name> boolean validate(T name) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(name);
		violations.stream().forEach(p -> System.out.println(Colorize.yellow(p.getMessage())));
		return violations.size() > 0 ? false : true;
	}

	private <T extends Name> String getFormattedMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append("> ");
		sb.append(message);
		if (StringUtils.isNotBlank(defaultValue)) {
			sb.append(" (");
			sb.append(defaultValue);
			sb.append(")");
		}
		sb.append(": ");
		return sb.toString();
	}

}
