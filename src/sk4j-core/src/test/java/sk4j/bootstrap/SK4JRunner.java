package sk4j.bootstrap;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import sk4j.core.Beans;

public class SK4JRunner extends BlockJUnit4ClassRunner {

	@SuppressWarnings("rawtypes")
	private final Class klass;
	private final Weld weld;
	private final WeldContainer container;

	public SK4JRunner(Class<?> klass) throws InitializationError {
		super(klass);
		this.klass = klass;
		this.weld = new Weld();
		this.container = weld.initialize();
		Beans.setBeanManager(container.getBeanManager());
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Object createTest() throws Exception {
		final Object test = container.instance().select(klass).get();
		return test;
	}

}
