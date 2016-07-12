package sk4j.impl;

import java.io.IOException;
import java.util.List;

import sk4j.api.Console;
import sk4j.core.console.CColor;
import sk4j.core.exception.InvalidOptionException;
import sk4j.core.input.Choosable;
import sk4j.core.input.InputReader;
import sk4j.core.input.MultipleOptionInputReader;
import sk4j.core.input.SingleOptionInputReader;

public class ConsoleImpl implements Console {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void echo(String message) {
		System.out.println(message);
	}

	@Override
	public String readln(String label) throws IOException {
		return new InputReader(label).read();
	}

	@Override
	public <T extends Choosable<T>> T readOption(String label, List<T> options) throws IOException, InvalidOptionException {
		return new SingleOptionInputReader<>(label, options).readOption();
	}

	@Override
	public <T extends Choosable<T>> List<T> readOptions(String label, List<T> options) throws IOException, InvalidOptionException {
		return new MultipleOptionInputReader<>(label, options).readOptions();
	}

	@Override
	public void exit(String message) {
		System.out.println("");
		System.out.println("**************************************");
		System.out.println(CColor.red(message));
		System.exit(1);

	}

}
