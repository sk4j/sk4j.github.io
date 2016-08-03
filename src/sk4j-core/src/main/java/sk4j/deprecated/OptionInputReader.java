package sk4j.deprecated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.Colorize;
import sk4j.exception.EmptyOptionParamException;
import sk4j.input.Selectable;

public class OptionInputReader<T extends Selectable<T>> extends InputReader {

	private List<T> options = new ArrayList<>();

	public OptionInputReader(String label, List<T> options) {
		super(label);
		this.options = options;
	}

	/**
	 * Exibe as opções no console.
	 * 
	 */
	//@formatter:off
	public void printOptions() {
		AtomicInteger index = new AtomicInteger();
		System.out.println("");
		this.options = this.options.stream().sorted().collect(Collectors.toList());
		options
			.stream()
			.sorted()
			.map(opt -> String.format("%s : %s", Colorize.magenta(StringUtils.rightPad(String.valueOf(index.incrementAndGet()), 2)), Colorize.bold(opt.getSelectLabel())))
			.forEach(System.out::println);
	}
	//@formatter:on

	/**
	 * Verifica se a opção de entrada é valida.
	 * 
	 * @param value
	 * @return
	 * @throws InvalidOptionException
	 */
	//@formatter:off
	protected boolean isValidOption(String value) {
		Pattern pattern = Pattern.compile("\\s*\\d\\d*");
		boolean stringIsDigit = pattern.matcher(value).matches();
		if (stringIsDigit) {
			boolean digitInRange = IntStream.rangeClosed(1, options.size())
										    .anyMatch(p -> p == Integer.valueOf(value));
			if (!digitInRange) {
				return false;
			}
			return true;
		}
		return false;
	}
	//@formatter:on

	public List<T> getOptions() {
		return options;
	}

	@Override
	public String read() {
		if (this.options == null || this.options.isEmpty()) {
			throw new EmptyOptionParamException("Nenhuma opção disponível para seleção.");
		}
		return super.read();
	}

}
