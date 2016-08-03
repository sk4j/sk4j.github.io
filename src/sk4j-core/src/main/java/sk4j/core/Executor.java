package sk4j.core;

import java.util.List;

import sk4j.console.Executable;

public interface Executor<T extends Executable> extends Executable {
	void executeOne(List<T> actions);

	void executeMany(List<T> actions);
}
