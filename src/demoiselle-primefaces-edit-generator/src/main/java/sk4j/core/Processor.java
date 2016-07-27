package sk4j.core;

import java.io.IOException;
import java.io.Serializable;

public interface Processor extends Serializable {
	void process() throws IOException;
}
