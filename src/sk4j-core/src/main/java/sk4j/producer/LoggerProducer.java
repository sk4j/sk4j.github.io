package sk4j.producer;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

import sk4j.proxy.Slf4jLoggerProxy;

public class LoggerProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Default
	@Produces
	public Logger create(final InjectionPoint ip) {
		Class<?> type;

		if (ip != null && ip.getMember() != null) {
			type = ip.getMember().getDeclaringClass();
		} else {
			type = LoggerProducer.class;
		}

		return create(type);
	}

	public static <T> Logger create(Class<T> type) {
		return new Slf4jLoggerProxy(type);
	}
}
