package sk4j.producer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import sk4j.core.Context;
import sk4j.input.custom.StringReader;

public class StringReaderProducer {

	@Inject
	private Context context;

	@Produces
	public StringReader create(InjectionPoint ip) {
		Field field = (Field) ip.getMember();
		System.out.println(field.getName());
		for (Annotation annotation : field.getAnnotations()) {
			System.out.println(annotation.annotationType());
		}
		// Arrays.asList(field.getDeclaredAnnotations()).stream().forEach(ann -> ann.annotationType());
		return new StringReader(context, field.getName(), field);
	}
}
