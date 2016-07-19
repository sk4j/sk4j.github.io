package sk4j.core;

import java.io.Serializable;

import javax.inject.Singleton;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

@Singleton
public class EntityReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Multimap<String, String> reportMultimap;

	public EntityReport() {
		super();
		this.reportMultimap = ArrayListMultimap.create();
	}

	public void addReportItem(String entity, String reportItem) {
		reportMultimap.put(entity, reportItem);
	}

	public Multimap<String, String> getReportMultimap() {
		return reportMultimap;
	}

}
