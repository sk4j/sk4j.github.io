package sk4j.core.input;

import java.io.IOException;
import java.util.List;

import sk4j.core.exception.InvalidOptionException;

public class SingleOptionInputReader<T extends Choosable<T>> extends OptionInputReader<T> {

	public SingleOptionInputReader(String label, List<T> options) {
		super(label, options);
	}

	public T readOption() throws IOException, InvalidOptionException {
		printOptions();
		read();
		validateOption();
		return this.getOptions().get(Integer.valueOf(getValue()) - 1);
	}

}
