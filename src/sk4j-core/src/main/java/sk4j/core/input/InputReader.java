package sk4j.core.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

	private String value;

	private String label;

	public InputReader(String label) {
		super();
		this.label = label;
	}

	/**
	 * Lê uma String do console.
	 * 
	 * @return String lida do console.
	 * @throws IOException
	 */
	public String read() throws IOException {
		System.out.println("");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(String.format("%s", label));
		return value = bufferedReader.readLine();
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
