package sk4j.deprecated;

import java.util.List;

import org.slf4j.Logger;

import sk4j.console.Colorize;
import sk4j.input.Selectable;

public class SingleOptionInputReader<T extends Selectable<T>> extends OptionInputReader<T> {

	private Logger log;

	public SingleOptionInputReader(String label, List<T> options, Logger log) {
		super(label, options);
		this.log = log;
	}

	public T readOption() {
		printOptions();
		return _readOption();
	}

	private T _readOption() {
		read();
		if (!isValidOption(getValue())) {
			log.warn(Colorize.yellow("Opção inválida: {}"), getValue());
			_readOption();
		}
		return this.getOptions().get(Integer.valueOf(getValue()) - 1);
	}

}
