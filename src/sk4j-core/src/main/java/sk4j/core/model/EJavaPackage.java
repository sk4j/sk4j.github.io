package sk4j.core.model;

import java.io.Serializable;

import sk4j.core.console.Choosable;

public class EJavaPackage implements Serializable, Choosable<EJavaPackage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String path;

	@Override
	public int compareTo(EJavaPackage o) {
		return 0;
	}

	@Override
	public String getChoiseLabel() {
		return null;
	}

}
