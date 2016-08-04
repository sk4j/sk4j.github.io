package sk4j.implementation;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.core.Log;
import sk4j.input.Reader;
import sk4j.validator.ReaderValidator;

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

	private String value;

	private String contextKey;

	private ReaderValidator validator;

	public ReaderImpl(Context context, Log log, String message, String contextKey, ReaderValidator validator) {
		super();
		this.context = context;
		this.log = log;
		this.message = message;
		this.contextKey = contextKey;
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
		// console.setCopyPasteDetection(true);
		console.setHandleUserInterrupt(true);
		console.setPrompt(String.format("\n> %s", getMessage()));
		this.value = StringUtils.trim(console.readLine());
		console.close();
	}

	private void putToContext() {
		if (StringUtils.isNotBlank(this.contextKey)) {
			context.put(contextKey, this.value);
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

	@Override
	public String read(String defaultValue) {
		return null;
	}

	protected String getMessage() {
		return StringUtils.appendIfMissing(Colorize.bgGreen(this.message), " : ");
	}

}
