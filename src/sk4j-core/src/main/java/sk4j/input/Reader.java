package sk4j.input;

import java.io.Serializable;
import java.util.List;

import sk4j.input.api.Executable;
import sk4j.input.api.Nameable;
import sk4j.input.api.Selectable;

/**
 * Leitor de opções do console.
 * 
 * @author jcruz
 *
 */
public interface Reader extends Serializable {

	<T extends Nameable> T read(Class<T> nameableOption);

	/**
	 * Seleciona uma opção de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Opção selecionada.
	 */
	<T extends Selectable<T>> T selectOne(List<T> selectableOptions);

	/**
	 * Seleciona uma lista de opções de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Lista de opções selecionadas.
	 */
	<T extends Selectable<T>> List<T> selectMany(List<T> selectableOptions);

	/**
	 * Seleciona e executa uma opção de uma lista de executáveis.
	 * 
	 * @param executableOptions
	 *            Lista de executáveis.
	 */
	<T extends Executable<T>> void selectAndExecuteOne(List<T> executableOptions);

	/**
	 * Seleciona e executa uma lista opções de uma lista de executáveis.
	 * 
	 * @param executableOptions
	 *            Lista de executáveis.
	 */
	<T extends Executable<T>> void selectAndExecuteMany(List<T> executableOptions);

	/**
	 * Confirma uma opção executável.
	 * 
	 * @param executableOption
	 *            Opção executável.
	 */
	<T extends Executable<T>> void confirm(Class<T> executableOption);

}
