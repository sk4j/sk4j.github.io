package sk4j.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import sk4j.api.Context;
import sk4j.core.model.EProject;

@Singleton
public class ContextImpl implements Context {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctx = new HashMap<>();

	private EProject project;

	@Override
	public void putItem(String key, Object value) {
		this.ctx.put(key, value);
	}

	@Override
	public Object getItem(String key) {
		return this.getItem(key);
	}

	@Override
	public Map<String, Object> get() {
		return this.ctx;
	}

	@Override
	public void setProject(EProject project) {
		this.project = project;
	}

	@Override
	public EProject getProject() {
		return this.project;
	}

	@Override
	public String replace(String value) {
		JtwigTemplate template = JtwigTemplate.inlineTemplate(value);
		JtwigModel model = JtwigModel.newModel().with("project", project);
		ctx.forEach((k, v) -> model.with(k, v));
		return template.render(model);
	}

}
