package sk4j.implementation;

import java.util.Arrays;

import sk4j.console.ConsoleColor;
import sk4j.core.Log;

public class LogImpl implements Log {

	@Override
	public void debug(String message) {
		System.out.println(ConsoleColor.gray(message));
	}

	@Override
	public void debug(String message, Object... params) {
		System.out.println(String.format(ConsoleColor.gray(message), Arrays.asList(params).stream().map(String::valueOf).toArray()));
	}

	@Override
	public void info(String message) {
		System.out.println(ConsoleColor.blue(message));
	}

	@Override
	public void warn(String message) {
		System.out.println(ConsoleColor.yellow(message));
	}

	@Override
	public void error(String message) {
		System.out.println(ConsoleColor.red(message));
	}
}
