package sk4j.console.reader;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import jline.console.ConsoleReader;
import sk4j.console.ConsoleColor;

public class InputReader {

	private String value;

	private String label;

	public InputReader(String label) {
		super();
		this.label = StringUtils.appendIfMissing(ConsoleColor.bgGreen(label), " : ");
	}

	/**
	 * Lê uma String do console.
	 * 
	 * @return String lida do console.
	 * @throws IOException
	 */
	public String read() {
		// BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			ConsoleReader console = new ConsoleReader();
			System.out.println("");
			console.setPrompt(String.format("> %s", label));
			value = console.readLine();
			console.close();
		} catch (IOException e) {
			System.out.println(ConsoleColor.red("Erro ao ler entrada de dados."));
			System.exit(1);
		}
		return StringUtils.trim(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
