package sk4j.input.api;

import sk4j.input.annotation.ExecutableConf;

/**
 * @author jcruz
 *
 * @param <T>
 */
@FunctionalInterface
public interface Executable<T> extends Selectable<T> {

	/**
	 * Método com lógica de execução.
	 */
	void execute();

	@Override
	default int compareTo(T o) {
		if (this.getClass().isAnnotationPresent(ExecutableConf.class)) {
			int thisOrder = this.getClass().getAnnotation(ExecutableConf.class).order();
			int otherOrder = o.getClass().getAnnotation(ExecutableConf.class).order();
			return Integer.compare(thisOrder, otherOrder);
		}
		return this.getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
	}

	@Override
	default String getSelectLabel() {
		if (this.getClass().isAnnotationPresent(ExecutableConf.class)) {
			return this.getClass().getAnnotation(ExecutableConf.class).message();
		}
		return this.getClass().getSimpleName();
	}
}
