package sk4j.input

/**
 * Classe que transforma uma string em um opção de seleçã no console.
 * 
 * @author jcruz
 *
 */
class StringChooser implements Choosable<String> {

	String value

	public StringChooser(String value) {
		super()
		this.value = value
	}

	@Override
	public int compareTo(String o) {
		return this.compareTo(o)
	}

	@Override
	public String getChoiseLabel() {
		return value
	}
}
