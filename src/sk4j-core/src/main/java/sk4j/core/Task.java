package sk4j.core;

import sk4j.annotation.TaskConf;
import sk4j.input.api.Selectable;

@FunctionalInterface
public interface Task extends Selectable<Task> {

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

	@Override
	default String getSelectLabel() {
		if (this.getClass().isAnnotationPresent(TaskConf.class)) {
			return this.getClass().getAnnotation(TaskConf.class).label();
		}
		return this.getClass().getSimpleName();
	}

}
