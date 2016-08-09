package sk4j.input;

import java.io.IOException;
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

	/**
	 * Seleciona uma opção de uma lista de selecionáveis.
	 * 
	 * @param message
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Opção selecionada.
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> T selectOne(List<T> selectableOptions, String message) throws IOException;

	/**
	 * Seleciona uma lista de opções de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Lista de opções selecionadas.
	 */
	<X, T extends Selectable<X>> List<T> selectMany(List<T> selectableOptions, String message);

	/**
	 * Seleciona e executa uma opção de uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 */
	<T extends Task> void selectAndExecuteOne(Iterator<T> taskOptions, String message);

	/**
	 * Seleciona e executa uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 */
	<T extends Task> void selectAndExecuteMany(Iterator<T> taskOptions, String message);

	/**
	 * Confirma a execução de uma tarefa.
	 * 
	 * @param taskOption
	 *            Opção executável.
	 */
	<T extends Task> void confirm(T taskOption, String message);

}
