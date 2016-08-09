package sk4j.implementation;

import java.util.Iterator;
import java.util.List;

import sk4j.input.Selector;
import sk4j.input.api.Selectable;
import sk4j.input.api.Task;

public class SelectorImpl implements Selector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <X, T extends Selectable<X>> T selectOne(List<T> selectableOptions, String message) {
		return null;
	}

	@Override
	public <X, T extends Selectable<X>> List<T> selectMany(List<T> selectableOptions, String message) {
		return null;
	}

	@Override
	public <T extends Task> void selectAndExecuteOne(Iterator<T> taskOptions, String message) {

	}

	@Override
	public <T extends Task> void selectAndExecuteMany(Iterator<T> taskOptions, String message) {

	}

	@Override
	public <T extends Task> void confirm(T taskOption, String message) {

	}

}
