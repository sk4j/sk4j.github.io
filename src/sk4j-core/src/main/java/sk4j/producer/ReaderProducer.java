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
import sk4j.validator.custom.ReaderYesNoValidator;

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
		if (field.isAnnotationPresent(ReaderConf.class)) {
			ReaderConf readerConf = field.getAnnotation(ReaderConf.class);
			//@formatter:off
			String message = StringUtils.isNotBlank(readerConf.message()) ? 
								readerConf.message() : 
								"Digite";
			String contextKey = StringUtils.isNotBlank(readerConf.contextKey()) ? 
								readerConf.contextKey() : 
								fieldContextKey;
			ReaderValidator readerValidator = readerConf.confirmationMode() ? 
								readerValidators.get(ReaderYesNoValidator.class.getSimpleName()) : 
								readerValidators.get(readerConf.validator().getSimpleName());
			//@formatter:on
			return new ReaderImpl(context, log, message, contextKey, readerValidator);

		}
		return new ReaderImpl(context, log, "Digite", fieldContextKey, readerValidators.get(ReaderDefaultValidator.class.getSimpleName()));
	}

}
