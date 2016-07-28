package sk4j.producer;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import sk4j.core.Checker;

public class CheckerProducer {

	@Inject
	private Instance<Checker> checkers;

	@Produces
	@Singleton
	public Map<String, Checker> create() {
		Map<String, Checker> checkersMap = new HashMap<>();
		checkers.forEach(checker -> checkersMap.put(checker.getClass().getSimpleName(), checker));
		return checkersMap;
	}
}
