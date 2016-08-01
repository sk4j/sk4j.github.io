package sk4j.producer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import sk4j.core.ConsoleReaderValidator;

public class ConsoleValidatorProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Instance<ConsoleReaderValidator> validators;

	@Produces
	@Singleton
	public Map<String, ConsoleReaderValidator> create() {
		Map<String, ConsoleReaderValidator> map = new HashMap<>();
		validators.iterator().forEachRemaining(v -> map.put(v.getClass().getSimpleName(), v));
		return map;
	}
}
