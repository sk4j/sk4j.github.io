package sk4j.input;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import sk4j.core.Task;

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
	<X, T extends Selectable<X>> T selectOne(String message, List<T> selectableOptions) throws IOException;

	/**
	 * 
	 * @param message
	 * @param contextKey
	 * @param selectableOptions
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> void selectOne(String message, String contextKey, List<T> selectableOptions) throws IOException;

	/**
	 * Seleciona uma opção de uma lista de selecionáveis.
	 * 
	 * @param message
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Opção selecionada.
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> T selectOne(String message, Iterable<T> selectableOptions) throws IOException;

	/**
	 * 
	 * @param message
	 * @param cotextKey
	 * @param selectableOptions
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> void selectOne(String message, String cotextKey, Iterable<T> selectableOptions) throws IOException;

	/**
	 * Seleciona uma lista de opções de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Lista de opções selecionadas.
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> List<T> selectMany(String message, List<T> selectableOptions) throws IOException;

	/**
	 * 
	 * @param message
	 * @param contextKey
	 * @param selectableOptions
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> void selectMany(String message, String contextKey, List<T> selectableOptions) throws IOException;

	/**
	 * Seleciona uma lista de opções de uma lista de selecionáveis.
	 * 
	 * @param selectableOptions
	 *            Lista de selecionáveis.
	 * @return Lista de opções selecionadas.
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> List<T> selectMany(String message, Iterable<T> selectableOptions) throws IOException;

	/**
	 * 
	 * @param message
	 * @param contextKey
	 * @param selectableOptions
	 * @throws IOException
	 */
	<X, T extends Selectable<X>> void selectMany(String message, String contextKey, Iterable<T> selectableOptions) throws IOException;

	/**
	 * Seleciona e executa uma opção de uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 * @throws IOException
	 */
	<T extends Task> void selectAndExecuteOne(String message, List<T> taskOptions) throws IOException;

	/**
	 * Seleciona e executa uma opção de uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 * @throws IOException
	 */
	<T extends Task> void selectAndExecuteOne(String message, Iterable<T> taskOptions) throws IOException;

	/**
	 * Seleciona e executa uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 * @throws IOException
	 */
	<T extends Task> void selectAndExecuteMany(String message, List<T> taskOptions) throws IOException;

	/**
	 * Seleciona e executa uma lista de tarefas.
	 * 
	 * @param taskOptions
	 *            Lista de tarefas.
	 * @throws IOException
	 */
	<T extends Task> void selectAndExecuteMany(String message, Iterable<T> taskOptions) throws IOException;

	/**
	 * Confirma a execução de uma tarefa.
	 * 
	 * @param taskOption
	 *            Opção executável.
	 * @throws IOException
	 */
	<T extends Task> void confirm(String message, T taskOption) throws IOException;

}
