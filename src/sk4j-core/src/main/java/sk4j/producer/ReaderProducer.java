package sk4j.producer;

import java.lang.reflect.Field;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.Context;
import sk4j.implementation.SelectorImpl;
import sk4j.input.Selector;
import sk4j.input.annotation.ReaderConf;

public class ReaderProducer {

	@Inject
	private Context context;

	@Produces
	@Default
	public Selector create(InjectionPoint ip) {
		Field field = (Field) ip.getMember();
		String contextKey = field.getName().replaceAll("Reader", "");
		String message = "";
		if (field.isAnnotationPresent(ReaderConf.class)) {
			message = field.getAnnotation(ReaderConf.class).message();
			contextKey = StringUtils.isNotBlank(field.getAnnotation(ReaderConf.class).contextKey())
					? field.getAnnotation(ReaderConf.class).contextKey() : contextKey;
			if (!field.getAnnotation(ReaderConf.class).ignoreContext()) {
				contextKey = null;
			}
		}
		return new SelectorImpl(context, message, contextKey);
	}
}
