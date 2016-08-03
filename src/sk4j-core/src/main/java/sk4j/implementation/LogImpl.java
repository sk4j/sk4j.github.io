package sk4j.implementation;

import java.util.Arrays;

import sk4j.console.Colorize;
import sk4j.core.Log;

public class LogImpl implements Log {

	@Override
	public void debug(String message) {
		System.out.println(Colorize.gray(message));
	}

	@Override
	public void debug(String message, Object... params) {
		System.out.println(String.format(Colorize.gray(message), Arrays.asList(params).stream().map(String::valueOf).toArray()));
	}

	@Override
	public void info(String message) {
		System.out.println(Colorize.blue(message));
	}

	@Override
	public void warn(String message) {
		System.out.println(Colorize.yellow(message));
	}

	@Override
	public void error(String message) {
		System.out.println(Colorize.red(message));
	}
}
