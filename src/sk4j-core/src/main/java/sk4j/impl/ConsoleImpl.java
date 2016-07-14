package sk4j.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import sk4j.api.Console;
import sk4j.api.Context;
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

	@Inject
	private Context ctx;

	@Override
	public <T extends Choosable<T>> T readOption(String label, List<T> options) {
		try {
			return new SingleOptionInputReader<>(label, options).readOption();
		} catch (IOException e) {
			exit("Erro ao ler entrada de dados. " + e.getMessage());
		} catch (InvalidOptionException e) {
			exit(e.getMessage());
		}
		return null;
	}

	@Override
	public <T extends Choosable<T>> List<T> readOptions(String label, List<T> options) {
		try {
			return new MultipleOptionInputReader<>(label, options).readOptions();
		} catch (IOException e) {
			exit("Erro ao ler entrada de dados. " + e.getMessage());
		} catch (InvalidOptionException e) {
			exit(e.getMessage());
		}
		return null;
	}

	@Override
	public void exit(String message) {
		message = ctx.replace(message);
		System.out.println("");
		System.out.println("**************************************");
		System.out.println(CColor.red(message));
		System.exit(1);

	}

	@Override
	public String readln(String label) {
		label = String.format("> %s", ctx.replace(label));
		try {
			return new InputReader(CColor.bold(label)).read();
		} catch (IOException e) {
			exit("Erro ao ler entrada de dados. " + e.getMessage());
		}
		return null;
	}

	@Override
	public String readln(String label, ConsoleConf conf) {
		String ln = readln(label);
		return null;
	}

	@Override
	public String readln(String label, String defaultValue, ConsoleConf conf) {
		return null;
	}

	@Override
	public String readln(String label, String defaultValue) {
		return null;
	}

	@Override
	public YesNoOption readYesNo(String label) {
		return null;
	}

	@Override
	public YesNoOption readYesNO(String label, YesNoOption defaultValue) {
		return null;
	}

}
