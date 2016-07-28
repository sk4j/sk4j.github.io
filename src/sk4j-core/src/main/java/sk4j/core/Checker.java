package sk4j.core;

import java.io.Serializable;

import sk4j.api.model.EJavaProject;

public interface Checker extends Serializable {
	public void check(EJavaProject project) throws CheckerException;
}
