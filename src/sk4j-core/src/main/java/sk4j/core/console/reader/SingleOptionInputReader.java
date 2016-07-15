package sk4j.core.console.reader;

import java.util.List;

import sk4j.core.console.Choosable;

public class SingleOptionInputReader<T extends Choosable<T>> extends OptionInputReader<T> {

	public SingleOptionInputReader(String label, List<T> options) {
		super(label, options);
	}

	public T readOption() {
		printOptions();
		read();
		if (!isValidOption(getValue())) {
			// throw new InvalidOptionException(String.format("Opção inválida: %s", getValue()));
		}
		return this.getOptions().get(Integer.valueOf(getValue()) - 1);
	}

}
