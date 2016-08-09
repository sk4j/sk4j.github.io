package sk4j.implementation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.core.Context;
import sk4j.input.Selector;
import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

public class SelectorImpl implements Selector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Context context;

	private String contextKey;

	private String message;

	private String defaultValue;

	public SelectorImpl(Context context, String message, String contextKey) {
		super();
		this.context = context;
		this.message = message;
		this.contextKey = contextKey;
	}

	@Override
	public <X, T extends Selectable<X>> T selectOne(List<T> selectableOptions) {
		return null;
	}

	@Override
	public <X, T extends Selectable<X>> List<T> selectMany(String message, List<T> selectableOptions) {
		return null;
	}

	@Override
	public <T extends Task> void selectAndExecuteOne(Iterator<T> taskOptions) {

	}

	@Override
	public <T extends Task> void selectAndExecuteMany(Iterator<T> taskOptions) {

	}

	@Override
	public <T extends Task> void confirm(T taskOption) {

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
