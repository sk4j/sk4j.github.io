package sk4j.implementation;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.ConsoleColor;
import sk4j.core.ConsoleReaderValidator;
import sk4j.core.SimpleReader;
import sk4j.core.SystemContext;

public class SimpleReaderImpl implements SimpleReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SystemContext systemContext;

	private String message;

	private String value;

	private String contextKey;

	private ConsoleReaderValidator validator;

	public SimpleReaderImpl(String message) {
		super();
		this.message = message;
	}

	public SimpleReaderImpl(String message, String contextKey) {
		super();
		this.message = message;
		this.contextKey = contextKey;
	}

	public SimpleReaderImpl(String message, String contextKey, ConsoleReaderValidator validator) {
		super();
		this.message = message;
		this.contextKey = contextKey;
		this.validator = validator;
	}

	@Override
	public String read() throws IOException {
		readFromConsole();
		validateInput();
		putToSystemContext();
		return StringUtils.trim(value);
	}

	private void readFromConsole() throws IOException {
		ConsoleReader console = new ConsoleReader();
		console.setHandleUserInterrupt(true);
		console.setPrompt(String.format("\n> %s\n", getMessage()));
		this.value = console.readLine();
		console.close();
	}

	private void putToSystemContext() {
		if (this.contextKey != null) {
			systemContext.put(contextKey, this.value);
		}
	}

	private void validateInput() throws IOException {
		if (validator != null) {
			if (!validator.validate(value)) {
				read();
			}
		}
	}

	@Override
	public String read(String defaultValue) {
		return null;
	}

	protected String getMessage() {
		return StringUtils.appendIfMissing(ConsoleColor.bgGreen(this.message), " : ");
	}

}
