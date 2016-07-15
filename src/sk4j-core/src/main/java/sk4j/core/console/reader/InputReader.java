package sk4j.core.console.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.console.ConsoleColor;

public class InputReader {

	private String value;

	private String label;

	public InputReader(String label) {
		super();
		this.label = StringUtils.appendIfMissing(label, " : ");
	}

	/**
	 * Lê uma String do console.
	 * 
	 * @return String lida do console.
	 * @throws IOException
	 */
	public String read() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(String.format("> %s", label));
		try {
			value = bufferedReader.readLine();
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
