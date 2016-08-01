package sk4j.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.core.SystemContext;
import sk4j.model.EJavaProject;

@Singleton
public class SystemContextImpl implements SystemContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctx = new HashMap<>();

	@Inject
	private EJavaProject project;

	@Override
	public void put(String key, Object value) {
		this.ctx.put(key, value);
	}

	@Override
	public Object get(String key) {
		Object value = this.ctx.get(key);
		if (value instanceof String) {
			return replace((String) value);
		}
		return value;
	}

	@Override
	public String replace(String value) {
		JtwigTemplate template = JtwigTemplate.inlineTemplate(value);
		JtwigModel model = JtwigModel.newModel().with("project", project);
		ctx.forEach((k, v) -> model.with(k, v));
		return template.render(model);
	}

	@Override
	public Map<String, Object> getContext() {
		return this.ctx;
	}

}
