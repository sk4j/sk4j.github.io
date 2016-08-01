package sk4j.core;

import java.io.Serializable;

public interface Browser extends Serializable {
	void open(String url);
}
