package sk4j.implementation;

import java.io.IOException;
import java.util.Arrays;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.core.Log;
import sk4j.input.Reader;
import sk4j.validator.ReaderValidator;
import sk4j.validator.custom.ReaderYesNoValidator;

public class ReaderImpl implements Reader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	@Inject
	private Log log;

	private String message;

	private String defaultValue = "";

	private String value;

	private String contextKey;

	private ReaderValidator validator;

	private boolean ignoreContext;

	public ReaderImpl(String message, ReaderValidator validator) {
		super();
		this.message = message;
		this.validator = validator;
	}

	@Override
	public String read() throws IOException {
		readFromConsole();
		validateInput();
		putToContext();
		return value;
	}

	private void readFromConsole() throws IOException {
		ConsoleReader console = new ConsoleReader();
		console.setHandleUserInterrupt(true);
		console.setPrompt(getFormatedMessage());
		String _value = StringUtils.trim(console.readLine());
		this.value = StringUtils.isNotBlank(_value) ? value : defaultValue;
		console.close();
	}

	private String getFormatedMessage() {
		StringBuffer formatedMessage = new StringBuffer();
		formatedMessage.append(" > ");
		formatedMessage.append(Colorize.bold(message.replace(":", "")));
		if (StringUtils.isNotBlank(defaultValue)) {
			if (validator instanceof ReaderYesNoValidator) {
				if (Arrays.asList("y", "Y").contains(defaultValue)) {
					formatedMessage.append(" (Y/n)");
				} else {
					formatedMessage.append(" (y/N)");
				}
			} else {
				formatedMessage.append(" (");
				formatedMessage.append(defaultValue);
				formatedMessage.append(")");
			}
		} else {
			if (validator instanceof ReaderYesNoValidator) {
				formatedMessage.append(" (y/N)");
			}
		}
		formatedMessage.append(": ");
		return context.replace(formatedMessage.toString());
	}

	private void putToContext() {
		if (!ignoreContext) {
			if (StringUtils.isNotBlank(this.contextKey)) {
				context.put(contextKey, this.value);
			}
		}
	}

	private void validateInput() throws IOException {
		if (validator != null) {
			if (!validator.test(value)) {
				log.warn(validator.getMessageOnFail());
				this.value = null;
				this.read();
			}
		}
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setContextKey(String contextKey) {
		this.contextKey = contextKey;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setValidator(ReaderValidator validator) {
		this.validator = validator;
	}

	public void setIgnoreContext(boolean ignoreContext) {
		this.ignoreContext = ignoreContext;
	}

}
