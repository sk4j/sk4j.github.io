package sk4j.implementation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.input.Reader;
import sk4j.input.api.Nameable;
import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

public class ReaderImpl implements Reader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <T extends Nameable<T>> T read(String message, Class<T> nameableOption) {
		return null;
	}

	@Override
	public <T extends Selectable<T>> T selectOne(String message, List<T> selectableOptions) {
		return null;
	}

	@Override
	public <T extends Selectable<T>> List<T> selectMany(String message, List<T> selectableOptions) {
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

	private String read(String message) throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		consoleReader.setHandleUserInterrupt(true);
		String value = consoleReader.readLine(String.format("> %s :", Colorize.bgGreen(message)));
		consoleReader.close();
		return StringUtils.trim(value);
	}
}
