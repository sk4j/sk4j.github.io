package sk4j.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Range;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.input.Selector;
import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

public class SelectorImpl implements Selector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <X, T extends Selectable<X>> T selectOne(List<T> selectableOptions, String message) throws IOException {
		Map<Integer, T> options = printSelectableOptions(selectableOptions);
		return readSelectOne(options, message);
	}

	@Override
	public <X, T extends Selectable<X>> List<T> selectMany(List<T> selectableOptions, String message) throws IOException {
		Map<Integer, T> options = printSelectableOptions(selectableOptions);
		return readSelectMany(options, message);
	}

	@Override
	public <T extends Task> void selectAndExecuteOne(Iterator<T> taskOptions, String message) {

	}

	@Override
	public <T extends Task> void selectAndExecuteMany(Iterator<T> taskOptions, String message) {

	}

	@Override
	public <T extends Task> void confirm(T taskOption, String message) {

	}

	private <X, T extends Selectable<X>> Map<Integer, T> printSelectableOptions(List<T> selectableOptions) {
		AtomicInteger counter = new AtomicInteger(0);
		Map<Integer, T> optionMap = new HashMap<>();
		//@formatter:off
		selectableOptions
			.stream()
			.sorted()
			.forEach(s -> {
				optionMap.put(counter.incrementAndGet(), s);
				System.out.println(String.format("%s : %s", Colorize.magenta(counter.get()), s.getSelectLabel()));
			});
		//@formatter:on
		return optionMap;
	}

	private <X, T extends Selectable<X>> T readSelectOne(Map<Integer, T> options, String message) throws IOException {
		String value = readConsole(message);
		if (StringUtils.isNumeric(value)) {
			Integer option = Integer.valueOf(value);
			if (Range.closed(1, options.size()).contains(option)) {
				return options.get(option);
			}
		}
		System.out.println(
				Colorize.yellow(String.format("Opção inválida: %s. Escolha apenas um valor entre 1 e %d.", value, options.size())));
		return readSelectOne(options, message);
	}

	private <X, T extends Selectable<X>> List<T> readSelectMany(Map<Integer, T> options, String message) throws IOException {
		String value = readConsole(message);
		Range<Integer> optionRange = Range.closed(1, options.size());
		//@formatter:off
		List<String> values = value.equals("*") ? options.keySet().stream().map(String::valueOf).collect(Collectors.toList()) :
      							   Arrays.asList(value.split(",")).stream().distinct().collect(Collectors.toList());
		//@formatter:on
		if (values.stream().allMatch(StringUtils::isNumeric)) {
			List<Integer> optionValues = values.stream().map(Integer::valueOf).collect(Collectors.toList());
			if (optionValues.stream().allMatch(optionRange::contains)) {
				//@formatter:off
				return options.keySet()
							.stream()
							.filter(optionValues::contains)
							.map(options::get)
							.collect(Collectors.toList());
				//@formatter:on
			}
		}
		System.out.println(Colorize.yellow(String.format(
				"Opção inválida: %s. Escolha um valor entre 1 e %d. Use vírgula para selecionar mais de uma opção. Digite * para selecionar todos.",
				value, options.size())));
		return readSelectMany(options, message);
	}

	private String readConsole(String message) throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		consoleReader.setHandleUserInterrupt(true);
		String value = consoleReader.readLine(String.format("> %s: ", message));
		consoleReader.close();
		return StringUtils.trim(value);
	}

}
