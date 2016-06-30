package sk4j.input

/**
 * Classe que transforma uma string em um opção de seleçã no console.
 * 
 * @author jcruz
 *
 */
class StringChooser implements Choosable<StringChooser> {

	String value

	public StringChooser(String value) {
		super()
		this.value = value
	}

	@Override
	public int compareTo(StringChooser o) {
		return this.value.compareTo(o.value)
	}

	@Override
	public String getChoiseLabel() {
		return value
	}
}
