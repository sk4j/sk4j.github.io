package sk4j.input;

import java.util.List;

public interface Executor<T extends Executable> extends Executable {
	void executeOne(List<T> actions);

	void executeMany(List<T> actions);
}
