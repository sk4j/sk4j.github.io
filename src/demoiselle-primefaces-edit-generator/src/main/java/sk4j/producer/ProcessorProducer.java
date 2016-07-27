package sk4j.producer;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import sk4j.core.Processor;
import sk4j.core.ProcessorId;

public class ProcessorProducer {

	@Inject
	private Instance<Processor> processors;

	@Produces
	@Default
	public Map<Integer, Processor> create() {
		Map<Integer, Processor> map = new HashMap<>();
		processors.forEach(p -> {
			if (p.getClass().isAnnotationPresent(ProcessorId.class)) {
				map.put(p.getClass().getAnnotation(ProcessorId.class).value(), p);
			}
		});
		return map;
	}
}
