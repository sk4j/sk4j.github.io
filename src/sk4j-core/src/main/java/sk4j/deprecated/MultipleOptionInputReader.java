package sk4j.deprecated;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import sk4j.console.Colorize;
import sk4j.input.Selectable;

public class MultipleOptionInputReader<T extends Selectable<T>> extends OptionInputReader<T> {

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
		System.out.println(String.format("a  : Selecionar todos"));
		read();
		boolean valid = getValue().equals("a") || Arrays.asList(getValue().split(","))
														.stream()
														.allMatch(p -> isValidOption(p));
		if(!valid) {
			log.warn(Colorize.yellow("Opção inválida: {}"), getValue());
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
