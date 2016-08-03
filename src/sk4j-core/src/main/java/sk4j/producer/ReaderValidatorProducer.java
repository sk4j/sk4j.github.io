package sk4j.producer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import sk4j.core.ReaderValidator;

public class ReaderValidatorProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Instance<ReaderValidator> validators;

	@Produces
	@Singleton
	public Map<String, ReaderValidator> create() {
		Map<String, ReaderValidator> map = new HashMap<>();
		validators.iterator().forEachRemaining(v -> map.put(v.getClass().getSimpleName(), v));
		return map;
	}
}
