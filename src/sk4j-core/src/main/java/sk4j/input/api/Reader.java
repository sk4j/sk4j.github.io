package sk4j.input.api;

import java.io.IOException;
import java.io.Serializable;

public interface Reader extends Serializable {

	<T extends Name> void read(T name, String message) throws IOException;

	<T extends Name> void read(T name, String message, String contextKey) throws IOException;
}
