package sk4j.api.reader;

import java.io.Serializable;
import java.util.List;

public interface OptionsReader<T> extends Serializable {
	List<T> read();
}
