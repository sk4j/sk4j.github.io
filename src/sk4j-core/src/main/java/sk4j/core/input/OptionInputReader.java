package sk4j.core.input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import sk4j.core.exception.InvalidOptionException;

public class OptionInputReader<T extends Choosable<T>> extends InputReader {

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
		options
			.stream()
			.map(opt -> String.format("%d > %s", index.incrementAndGet(), opt.getChoiseLabel()))
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
	protected boolean isValidOption(String value) {
		Pattern pattern = Pattern.compile("\\s*\\d\\d*");
		boolean stringIsDigit = pattern.matcher(value).matches();
		if (stringIsDigit) {
			boolean digitInRange = IntStream.rangeClosed(1, options.size()).anyMatch(p -> p == Integer.valueOf(value));
			if (!digitInRange) {
				return false;
			}
			return true;
		}
		return false;
	}

	public List<T> getOptions() {
		return options;
	}

}
