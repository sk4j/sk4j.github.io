package sk4j.implementation;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.Colorize;
import sk4j.core.Console;
import sk4j.core.Context;
import sk4j.deprecated.InputReader;
import sk4j.input.api.Selectable;

public class ConsoleImpl implements Console {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context ctx;

	// @Inject
	// private Logger log;

	@Override
	public <T extends Selectable<T>> T readOption(String label, List<T> options) {
		// return new SingleOptionInputReader<>(ctx.replace(label), options, log).readOption();
		return null;
	}

	@Override
	public <T extends Selectable<T>> List<T> readOptions(String label, List<T> options) {
		return null;
		// return new MultipleOptionInputReader<>(ctx.replace(label), options, log).readOptions();
	}

	@Override
	public void exit(String message) {
		message = ctx.replace(message);
		System.out.println("");
		System.out.print("*** ");
		System.out.println(Colorize.red(message));
		System.exit(1);

	}

	private String readInputReader(String label) {
		return new InputReader(ctx.replace(label)).read();
	}

	@Override
	public String read(String label) {
		return readInputReader(Colorize.bold(label));
	}

	@Override
	public String read(String label, String defaultValue) {
		String value = readInputReader(String.format("%s (%s)", Colorize.bold(label), defaultValue));
		System.out.println(Colorize.gray("Entrada: " + value));
		return StringUtils.isNotBlank(value) ? value : ctx.replace(defaultValue);
	}

}
