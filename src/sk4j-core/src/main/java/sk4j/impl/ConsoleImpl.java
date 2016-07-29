package sk4j.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import sk4j.api.Console;
import sk4j.api.Context;
import sk4j.console.Choosable;
import sk4j.console.ConsoleColor;
import sk4j.console.ConsoleValidator;
import sk4j.console.reader.InputReader;
import sk4j.console.reader.MultipleOptionInputReader;
import sk4j.console.reader.ReadConf;
import sk4j.console.reader.SingleOptionInputReader;
import sk4j.console.reader.YesNoOption;

public class ConsoleImpl implements Console {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context ctx;

	@Inject
	private Logger log;

	@Inject
	private Map<String, ConsoleValidator> validators;

	@Override
	public <T extends Choosable<T>> T readOption(String label, List<T> options) {
		return new SingleOptionInputReader<>(ctx.replace(label), options, log).readOption();
	}

	@Override
	public <T extends Choosable<T>> List<T> readOptions(String label, List<T> options) {
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
	public String read(String label, ReadConf conf) {
		String value = readInputReader(ConsoleColor.bold(label));
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		ConsoleValidator validator = validators.get(conf.getValidator().getSimpleName());
		return validator.validate(value) ? value : read(label, conf);
	}

	@Override
	public String read(String label, String defaultValue, ReadConf conf) {
		String value = readInputReader(String.format("%s (%s)", label, defaultValue));
		value = StringUtils.isNotBlank(value) ? value : ctx.replace(defaultValue);
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		ConsoleValidator validator = validators.get(conf.getValidator().getSimpleName());
		return validator.validate(value) ? value : read(label, defaultValue, conf);
	}

	@Override
	public String read(String label, String defaultValue) {
		String value = readInputReader(String.format("%s (%s)", ConsoleColor.bold(label), defaultValue));
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		return StringUtils.isNotBlank(value) ? value : ctx.replace(defaultValue);
	}

	@Override
	public YesNoOption readYesNo(String label) {
		String value = readInputReader(String.format("%s %s", ConsoleColor.bold(label), ConsoleColor.cyan("[y|n]")));
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		ConsoleValidator validator = validators.get(ReadConf.YES_NO.getValidator().getSimpleName());
		return validator.validate(value) ? YesNoOption.getOption(value) : readYesNo(label);
	}

	@Override
	public YesNoOption readYesNo(String label, YesNoOption defaultValue) {
		String value = readInputReader(
				String.format("%s %s (%s)", ConsoleColor.bold(label), ConsoleColor.cyan("[y|n]"), defaultValue.getValue()));
		ConsoleValidator validator = validators.get(ReadConf.YES_NO.getValidator().getSimpleName());
		value = StringUtils.isNotBlank(value) ? value : defaultValue.getValue();
		System.out.println(ConsoleColor.gray("Entrada: " + value));
		return validator.validate(value) ? YesNoOption.getOption(value) : readYesNo(label);
	}

}
