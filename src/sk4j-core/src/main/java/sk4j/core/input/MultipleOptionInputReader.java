package sk4j.core.input;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sk4j.core.exception.InvalidOptionException;

public class MultipleOptionInputReader<T extends Choosable<T>> extends OptionInputReader<T> {

	public MultipleOptionInputReader(String label, List<T> options) {
		super(label, options);
	}

	//@formatter:off
	public List<T> readOptions() throws IOException, InvalidOptionException {
		printOptions();
		System.out.println(String.format("a > Selecionar todos"));
		read();
		boolean valid = getValue().equals("a") || Arrays.asList(getValue().split(","))
														.stream()
														.allMatch(p -> isValidOption(p));
		if(!valid) {
			throw new InvalidOptionException(String.format("Opção inválida: %s", getValue()));
		}
		return getValue().equals("a") ? this.getOptions() :
				Arrays.asList(getValue().split(","))
					.stream()
					.map(p -> Integer.valueOf(p))
					.distinct()
					.map(p -> this.getOptions().get(p-1))
					.collect(Collectors.toList());
		//@formatter:on
	}

}
