package sk4j.input.api;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import jline.console.UserInterruptException;
import sk4j.console.Colorize;
import sk4j.core.Context;

/**
 * 
 * @author jcruz
 *
 */
public abstract class Name<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context;

	private String message;

	private String defaultValue;

	private String contextKey;

	public Name(Context context, String contextKey) {
		super();
		this.context = context;
		this.contextKey = contextKey;
	}

	abstract public T getValue();

	abstract public void setValue(T string);

	abstract public T asObject(String value);

	abstract public String asString(T nameable);

	public T getDefaultValue() {
		return null;
	}

	public boolean validate() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Name<T>>> violations = validator.validate(this);
		violations.stream().forEach(p -> System.out.println(Colorize.yellow(p.getMessage())));
		return violations.size() > 0 ? false : true;
	}

	public void read(String message) {
		this.message = message;
		try {
			if (getDefaultValue() != null) {
				this.defaultValue = asString(getDefaultValue());
			}
			String result = read();
			setValue(asObject(result));
			if (validate()) {
				if (StringUtils.isNotBlank(contextKey)) {
					context.put(contextKey, this);
				}
				return;
			}
			read(message);
		} catch (IOException e) {
			System.out.println("Erro ao ler entrada");
			throw new UserInterruptException("");
		}
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
}
