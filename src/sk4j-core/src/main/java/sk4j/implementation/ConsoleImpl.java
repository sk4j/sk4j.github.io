package sk4j.implementation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import sk4j.console.ConsoleColor;
import sk4j.console.ConsoleSelectable;
import sk4j.core.Console;
import sk4j.core.ConsoleReaderValidator;
import sk4j.core.SystemContext;
import sk4j.deprecated.InputReader;
import sk4j.deprecated.MultipleOptionInputReader;
import sk4j.deprecated.SingleOptionInputReader;

public class ConsoleImpl implements Console {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SystemContext ctx;

	@Inject
	private Logger log;

	@Inject
	private Map<String, ConsoleReaderValidator> validators;

	@Override
	public <T extends ConsoleSelectable<T>> T readOption(String label, List<T> options) {
		return new SingleOptionInputReader<>(ctx.replace(label), options, log).readOption();
	}

	@Override
	public <T extends ConsoleSelectable<T>> List<T> readOptions(String label, List<T> options) {
		return new MultipleOptionInputReader<>(ctx.replace(label), options, log).readOptions();
	}

	@Override
	public void exit(String message) {
		message = ctx.replace(message);
		System.out.println("");
		System.out.print("*** ");
		System.out.println(ConsoleColor.red(message));
		System.exit(1);

	}

	private String readInputReader(String label) {
		return new InputReader(ctx.replace(label)).read();
	}

	@Override
	public String read(String label) {
		return readInputReader(ConsoleColor.bold(label));
	}

	@Override
	public String read(String label, String defaultValue) {
		String value = readInputReader(String.format("%s (%s)", ConsoleColor.bold(label), defaultValue));
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		return StringUtils.isNotBlank(value) ? value : ctx.replace(defaultValue);
	}

}
