package sk4j.input.custom;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.core.Context;

public class StringReader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context;

	private String contextKey;

	private String value;

	private String message;

	private String defaultValue;

	private Field field;

	public StringReader(Context context, String contextKey, Field field) {
		super();
		this.context = context;
		this.contextKey = contextKey;
	}

	public void read(String message) {
		this.message = message;
	}

	public void read(String message, String defaultValue) {
		this.message = message;
		this.defaultValue = defaultValue;
	}

	protected boolean validate() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Field>> violations = validator.validate(field);
		violations.stream().forEach(p -> System.out.println(Colorize.yellow(p.getMessage())));
		return violations.size() > 0 ? false : true;
	}

	private String read() throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		consoleReader.setHandleUserInterrupt(true);
		String value = consoleReader.readLine(getFormattedMessage());
		consoleReader.close();
		return StringUtils.trim(value);
	}

	private String getFormattedMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append("> ");
		sb.append(context.replace(message));
		if (StringUtils.isNotBlank(defaultValue)) {
			sb.append(" (");
			sb.append(context.replace(defaultValue));
			sb.append(")");
		}
		sb.append(": ");
		return sb.toString();
	}

	public String getValue() {
		return value;
	}

}
