package sk4j.input;

import sk4j.input.annotation.ExecutorConf;

@FunctionalInterface
public interface Executable<T> extends Selectable<T> {

	void execute();

	@Override
	default int compareTo(T o) {
		if (this.getClass().isAnnotationPresent(ExecutorConf.class)) {
			int thisOrder = this.getClass().getAnnotation(ExecutorConf.class).order();
			int otherOrder = o.getClass().getAnnotation(ExecutorConf.class).order();
			return Integer.compare(thisOrder, otherOrder);
		}
		return this.getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
	}

	@Override
	default String getSelectLabel() {
		if (this.getClass().isAnnotationPresent(ExecutorConf.class)) {
			return this.getClass().getAnnotation(ExecutorConf.class).message();
		}
		return this.getClass().getSimpleName();
	}
}
