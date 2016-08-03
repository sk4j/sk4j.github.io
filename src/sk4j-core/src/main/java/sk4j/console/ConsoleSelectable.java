package sk4j.console;

public interface ConsoleSelectable<T> extends Comparable<T> {
	String getSelectLabel();
}
