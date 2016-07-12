package sk4j.core;

import java.util.HashMap;
import java.util.Map;

import org.jtwig.JtwigModel;

import sk4j.core.model.EProject;

/**
 * Classe que contem as variáveis de contexto utilizadas pelo template e aplicação.
 * 
 * @author jcruz
 *
 */
public class SkContext {

	private Map<String, Object> context;

	private EProject project;

	private static SkContext instance;

	private SkContext() {
		super();
		this.context = new HashMap<>();
	}

	/**
	 * Retorna a instancia do context;
	 * 
	 * @return
	 */
	public static SkContext get() {
		if (instance == null) {
			instance = new SkContext();
		}
		return instance;
	}

	/**
	 * Adiciona o item no contexto.
	 * 
	 * @param key
	 * @param value
	 */
	public void putItem(String key, Object value) {
		get().context.put(key, value);
	}

	/**
	 * 
	 * Rertorna o item do contexto.
	 * 
	 * @param key
	 */
	public Object getItem(String key) {
		return get().context.get(key);
	}

	/**
	 * 
	 * @return
	 */
	public JtwigModel getModel() {
		JtwigModel jtwigModel = JtwigModel.newModel();
		get().context.forEach((k, v) -> jtwigModel.with(k, v));
		return jtwigModel;
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public EProject getProject() {
		return project;
	}

	void setProject(EProject project) {
		this.project = project;
	}

}
