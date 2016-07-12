package sk4j.impl;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import sk4j.api.Context;

@SessionScoped
public class ContextImpl implements Context {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctx = new HashMap<>();

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

}
