package sk4j.api;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

public abstract class ConsoleReaderValidator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	public boolean validate(String t) {
		if (test(t)) {
			return true;
		}
		log.warn(consoleMessageOnFalse());
		return false;
	}

	protected abstract boolean test(String t);

	protected abstract String consoleMessageOnFalse();
}
