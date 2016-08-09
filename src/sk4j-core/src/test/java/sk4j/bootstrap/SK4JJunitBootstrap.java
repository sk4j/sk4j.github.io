package sk4j.bootstrap;

import java.util.Locale;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import sk4j.core.Beans;

public class SK4JJunitBootstrap implements Extension {
	public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> event) {
		final AnnotatedType<T> annotatedType = event.getAnnotatedType();

		for (AnnotatedMethod<?> am : annotatedType.getMethods()) {
			if (am.isAnnotationPresent(Produces.class) && am.getJavaMember().getReturnType() == Locale.class) {
				event.veto();
			}
		}
	}

	public void engineOn(@Observes final BeforeBeanDiscovery event, BeanManager beanManager) {
		System.out.println("Aquiiiiiiiiiiiiiiiiii");
		Beans.setBeanManager(beanManager);
	}
}
