package sk4j.input;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

/**
 * Leitor de opções do console.
 * 
 * @author jcruz
 *
 */
public interface Selector extends Serializable {

	// <X, T extends Nameable<X>> T read(T nameableOption) throws IOException;

	/**
	 * Seleciona uma opção de uma lista de selecionáveis.
	 * 
	 * @param message
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Opção selecionada.
	 */
	<X, T extends Selectable<X>> T selectOne(List<T> selectableOptions);

	/**
	 * Seleciona uma lista de opções de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Lista de opções selecionadas.
	 */
	<X, T extends Selectable<X>> List<T> selectMany(String message, List<T> selectableOptions);

	/**
	 * Seleciona e executa uma opção de uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 */
	<T extends Task> void selectAndExecuteOne(Iterator<T> taskOptions);

	/**
	 * Seleciona e executa uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 */
	<T extends Task> void selectAndExecuteMany(Iterator<T> taskOptions);

	/**
	 * Confirma a execução de uma tarefa.
	 * 
	 * @param taskOption
	 *            Opção executável.
	 */
	<T extends Task> void confirm(T taskOption);

}
