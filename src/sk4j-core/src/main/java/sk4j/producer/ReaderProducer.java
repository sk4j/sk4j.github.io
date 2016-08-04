package sk4j.producer;

import java.lang.reflect.Field;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.core.Context;
import sk4j.core.Log;
import sk4j.implementation.ReaderImpl;
import sk4j.input.Reader;
import sk4j.input.annotation.ReaderConf;
import sk4j.validator.ReaderValidator;
import sk4j.validator.custom.ReaderDefaultValidator;

public class ReaderProducer {

	@Inject
	private Map<String, ReaderValidator> readerValidators;

	@Inject
	private Context context;

	@Inject
	private Log log;

	@Produces
	public Reader create(InjectionPoint ip) {
		Field field = (Field) ip.getMember();
		String fieldContextKey = field.getName().replaceAll("Reader", "");
		ReaderImpl readerImpl = new ReaderImpl("Digite", readerValidators.get(ReaderDefaultValidator.class.getSimpleName()));
		readerImpl.setContext(context);
		readerImpl.setLog(log);
		readerImpl.setContextKey(fieldContextKey);
		if (field.isAnnotationPresent(ReaderConf.class)) {
			ReaderConf readerConf = field.getAnnotation(ReaderConf.class);
			if (StringUtils.isNotBlank(readerConf.message())) {
				readerImpl.setMessage(readerConf.message());
			}
			readerImpl.setIgnoreContext(readerConf.ignoreContext());
			if (!readerConf.ignoreContext()) {
				if (StringUtils.isNotBlank(readerConf.contextKey())) {
					readerImpl.setContextKey(readerConf.contextKey());
				}
			}
			readerImpl.setDefaultValue(readerConf.defaultValue());
			readerImpl.setValidator(readerValidators.get(readerConf.validator()));
			return readerImpl;

		}
		return readerImpl;
	}

}
