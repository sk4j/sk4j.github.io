package sk4j.core;

import java.util.List;

import sk4j.console.ConsoleActionable;

public interface ActionSelector<T extends ConsoleActionable> extends ConsoleActionable {
	void executeOne(List<T> actions);

	void executeMany(List<T> actions);
}
