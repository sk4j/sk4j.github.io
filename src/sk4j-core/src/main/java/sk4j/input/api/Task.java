package sk4j.input.api;

import java.io.Serializable;

import sk4j.input.annotation.TaskConf;

@FunctionalInterface
public interface Task extends Serializable, Comparable<Task> {

	void run();

	@Override
	default int compareTo(Task o) {
		if (this.getClass().isAnnotationPresent(TaskConf.class) && o.getClass().isAnnotationPresent(TaskConf.class)) {
			int thisOrder = this.getClass().getAnnotation(TaskConf.class).order();
			int otherOrder = o.getClass().getAnnotation(TaskConf.class).order();
			return Integer.compare(thisOrder, otherOrder);
		}
		return this.getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
	}

	default String message() {
		if (this.getClass().isAnnotationPresent(TaskConf.class)) {
			return this.getClass().getAnnotation(TaskConf.class).label();
		}
		return this.getClass().getSimpleName();
	}

}
