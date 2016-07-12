package sk4j.api;

import java.io.Serializable;

public interface Browser extends Serializable {
	void open(String url);
}
