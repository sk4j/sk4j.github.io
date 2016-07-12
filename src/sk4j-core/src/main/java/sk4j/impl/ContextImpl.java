package sk4j.impl;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import sk4j.api.Context;
import sk4j.core.model.EProject;

@SessionScoped
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

}