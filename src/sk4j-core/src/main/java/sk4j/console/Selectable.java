package sk4j.console;

public interface Selectable<T> extends Comparable<T> {
	String getSelectLabel();
}
