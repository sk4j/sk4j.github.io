package sk4j.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;

import jline.console.ConsoleReader;
import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.exception.EmptyOptionParamException;
import sk4j.input.Selector;
import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

public class SelectorImpl implements Selector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Context context;

	private String selectOneErrorMessage = "Opção inválida: %s. Escolha apenas um valor entre 1 e %d.";

	private String selectManyErrorMessage = "Opção inválida: %s. Escolha um valor entre 1 e %d. Use vírgula para selecionar mais de uma opção. Digite * para selecionar todos.";

	@Override
	public <X, T extends Selectable<X>> T selectOne(String message, List<T> selectableOptions) throws IOException {
		if (selectableOptions == null || selectableOptions.isEmpty()) {
			throw new EmptyOptionParamException();
		}
		Map<Integer, T> options = printSelectableOptions(selectableOptions);
		return readSelectOne(options, message);
	}

	@Override
	public <X, T extends Selectable<X>> T selectOne(String message, Iterable<T> selectableOptions) throws IOException {
		return selectOne(message, Lists.newArrayList(selectableOptions));
	}

	@Override
	public <X, T extends Selectable<X>> List<T> selectMany(String message, List<T> selectableOptions) throws IOException {
		if (selectableOptions == null || selectableOptions.isEmpty()) {
			throw new EmptyOptionParamException();
		}
		Map<Integer, T> options = printSelectableOptions(selectableOptions);
		return readSelectMany(options, message);
	}

	@Override
	public <X, T extends Selectable<X>> List<T> selectMany(String message, Iterable<T> selectableOptions) throws IOException {
		return selectMany(message, Lists.newArrayList(selectableOptions));
	}

	@Override
	public <T extends Task> void selectAndExecuteOne(String message, List<T> taskOptions) throws IOException {
		if (taskOptions == null || taskOptions.isEmpty()) {
			throw new EmptyOptionParamException();
		}
		Map<Integer, T> options = printSelectableOptions(taskOptions);
		readSelectOne(options, message).run();
	}

	@Override
	public <T extends Task> void selectAndExecuteOne(String message, Iterable<T> taskOptions) throws IOException {
		selectAndExecuteOne(message, Lists.newArrayList(taskOptions));
	}

	@Override
	public <T extends Task> void selectAndExecuteMany(String message, List<T> taskOptions) throws IOException {
		if (taskOptions == null || taskOptions.isEmpty()) {
			throw new EmptyOptionParamException();
		}
		Map<Integer, T> options = printSelectableOptions(taskOptions);
		readSelectMany(options, message).parallelStream().forEach(task -> task.run());
	}

	@Override
	public <T extends Task> void selectAndExecuteMany(String message, Iterable<T> taskOptions) throws IOException {
		selectAndExecuteMany(message, Lists.newArrayList(taskOptions));
	}

	@Override
	public <T extends Task> void confirm(String message, T taskOption) {

	}

	/**
	 * 
	 * @param selectableOptions
	 * @return
	 */
	private <X, T extends Selectable<X>> Map<Integer, T> printSelectableOptions(List<T> selectableOptions) {
		AtomicInteger counter = new AtomicInteger(0);
		Map<Integer, T> optionMap = new HashMap<>();
		//@formatter:off
		selectableOptions
			.stream()
			.sorted()
			.forEach(s -> {
				optionMap.put(counter.incrementAndGet(), s);
				System.out.println(String.format("%s : %s", Colorize.magenta(counter.get()), context.replace(s.getSelectLabel())));
			});
		//@formatter:on
		return optionMap;
	}

	/**
	 * 
	 * @param options
	 * @param message
	 * @return
	 * @throws IOException
	 */
	private <X, T extends Selectable<X>> T readSelectOne(Map<Integer, T> options, String message) throws IOException {
		String value = readConsole(message);
		if (StringUtils.isNumeric(value)) {
			Integer option = Integer.valueOf(value);
			if (Range.closed(1, options.size()).contains(option)) {
				return options.get(option);
			}
		}
		System.out.println(Colorize.yellow(String.format(selectOneErrorMessage, value, options.size())));
		return readSelectOne(options, message);
	}

	/**
	 * Seleciona varios selectable.
	 * 
	 * @param options
	 * @param message
	 * @return
	 * @throws IOException
	 */
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
		System.out.println(Colorize.yellow(String.format(selectManyErrorMessage, value, options.size())));
		return readSelectMany(options, message);
	}

	/**
	 * Lê um string do console.
	 * 
	 * @param message
	 *            Mensagem do prompt.
	 * @return String do console.
	 * @throws IOException
	 *             Erro na leitura do console.
	 */
	private String readConsole(String message) throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		consoleReader.setHandleUserInterrupt(true);
		String value = consoleReader.readLine(String.format("> %s: ", message));
		consoleReader.close();
		return StringUtils.trim(value);
	}

}
