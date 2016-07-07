package sk4j.core;

import java.io.IOException;

import sk4j.core.input.InputReader;

public class SkConsole {

	/**
	 * Exibe o texto no console.
	 * 
	 * @param value
	 */
	public static void echo(String value) {
		System.out.println(value);
	}

	/**
	 * 
	 * @param label
	 * @return
	 * @throws IOException
	 */
	public static String readln(String label) throws IOException {
		return new InputReader(label).read();
	}

}
