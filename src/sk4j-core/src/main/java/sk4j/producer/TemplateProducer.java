package sk4j.producer;

import java.lang.reflect.Field;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import sk4j.implementation.TemplateImpl;
import sk4j.template.Template;
import sk4j.template.annotation.TemplateConf;

public class TemplateProducer {

	@Produces
	@TemplateConf(name = "")
	public Template create(InjectionPoint ip) {
		Field field = (Field) ip.getMember();
		return new TemplateImpl(field.getAnnotation(TemplateConf.class).name());
	}
}
