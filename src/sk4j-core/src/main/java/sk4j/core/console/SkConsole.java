package sk4j.core.console;

import java.io.IOException;
import java.util.List;

import sk4j.core.exception.InvalidOptionException;
import sk4j.core.input.Choosable;
import sk4j.core.input.InputReader;
import sk4j.core.input.MultipleOptionInputReader;
import sk4j.core.input.SingleOptionInputReader;

/**
 * Classe que contem operações de entrada e saida no console.
 * 
 * @author jcruz
 *
 */
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
	 * Lê uma String do console.
	 * 
	 * @param label
	 *            Texto exibido no console ao lado do input de entrada.
	 * @return String do console.
	 * @throws IOException
	 */
	public static String readln(String label) throws IOException {
		return new InputReader(label).read();
	}

	/**
	 * Seleciona 1(uma) opção do console.
	 * 
	 * @param label
	 *            Texto exibido no console ao lado do input de entrada.
	 * @param options
	 *            Opções disponíveis para seleção.
	 * @return Opção selecionada.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	public static <T extends Choosable<T>> T readOption(String label, List<T> options) throws IOException, InvalidOptionException {
		return new SingleOptionInputReader<>(label, options).readOption();
	}

	/**
	 * Seleciona mais de uma opção do console.
	 * 
	 * @param label
	 *            Texto exibido no console ao lado do input de entrada.
	 * @param options
	 *            Opções disponíveis para seleção.
	 * @return Opções selecionadas.
	 * @throws IOException
	 * @throws InvalidOptionException
	 */
	public static <T extends Choosable<T>> List<T> readOptions(String label, List<T> options) throws IOException, InvalidOptionException {
		return new MultipleOptionInputReader<>(label, options).readOptions();
	}

	/**
	 * 
	 * @param message
	 */
	public static void log(String message, Object... args) {
		System.out.println(String.format(CColor.yellow(message), args));
	}

}
