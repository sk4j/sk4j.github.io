package sk4j.implementation;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.core.Context;

@Singleton
public class ContextImpl implements Context {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctx = new HashMap<>();

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
		JtwigModel model = JtwigModel.newModel();
		ctx.forEach((k, v) -> model.with(k, v));
		return template.render(model);
	}

	@Override
	public Map<String, Object> getContext() {
		return this.ctx;
	}

	@Override
	public String toString() {
		return this.ctx.toString();
	}

}
