package sk4j.core.console.reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;

public class MultipleOptionInputReader<T extends Choosable<T>> extends OptionInputReader<T> {

	private Logger log;

	public MultipleOptionInputReader(String label, List<T> options, Logger log) {
		super(label, options);
		this.log = log;
	}

	//@formatter:off
	public List<T> readOptions()  {
		printOptions();
		return _readOptions();
	}
	//@formatter:on

	private List<T> _readOptions() {
		System.out.println(String.format("a  > Selecionar todos\n"));
		read();
		boolean valid = getValue().equals("a") || Arrays.asList(getValue().split(","))
														.stream()
														.allMatch(p -> isValidOption(p));
		if(!valid) {
			log.warn(ConsoleColor.yellow("Opção inválida: {}"), getValue());
			_readOptions();
		}
		return getValue().equals("a") ? this.getOptions() :
				Arrays.asList(getValue().split(","))
					.stream()
					.map(Integer::valueOf)
					.distinct()
					.map(p -> this.getOptions().get(p-1))
					.collect(Collectors.toList());
	}

}
