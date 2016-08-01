package sk4j.api.reader;

import java.io.Serializable;

public interface OptionReader<T> extends Serializable {
	T read();
}
