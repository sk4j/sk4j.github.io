package sk4j.core;

import java.io.Serializable;

public interface AppValidator extends Serializable {
	void validate(BeforeStart event);
}
