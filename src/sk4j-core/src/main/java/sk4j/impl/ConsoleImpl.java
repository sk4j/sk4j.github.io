package sk4j.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;
import sk4j.core.console.ConsoleValidator;
import sk4j.core.console.reader.InputReader;
import sk4j.core.console.reader.MultipleOptionInputReader;
import sk4j.core.console.reader.ReadConf;
import sk4j.core.console.reader.SingleOptionInputReader;

public class ConsoleImpl implements Console {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context ctx;

	@Inject
	private Map<String, ConsoleValidator> validators;

	@Override
	public <T extends Choosable<T>> T readOption(String label, List<T> options) {
		return new SingleOptionInputReader<>(ctx.replace(label), options).readOption();
	}

	@Override
	public <T extends Choosable<T>> List<T> readOptions(String label, List<T> options) {
		return new MultipleOptionInputReader<>(ctx.replace(label), options).readOptions();
	}

	@Override
	public void exit(String message) {
		message = ctx.replace(message);
		System.out.println("");
		System.out.println("**************************************");
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
	public String read(String label, ReadConf conf) {
		String value = readInputReader(ConsoleColor.bold(label));
		ConsoleValidator validator = validators.get(conf.getValidator().getSimpleName());
		return validator.validate(value) ? value : read(label, conf);
	}

	@Override
	public String read(String label, String defaultValue, ReadConf conf) {
		String value = readInputReader(String.format("%s (%s) ", ConsoleColor.bold(label), defaultValue));
		ConsoleValidator validator = validators.get(conf.getValidator().getSimpleName());
		return validator.validate(value) ? value : read(label, defaultValue, conf);
	}

	@Override
	public String read(String label, String defaultValue) {
		return readInputReader(String.format("%s (%s) ", ConsoleColor.bold(label), defaultValue));
	}

}
