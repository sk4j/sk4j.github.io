package sk4j.api;

import java.io.Serializable;

import sk4j.api.model.EJavaProject;
import sk4j.exception.CheckerException;

public interface Checker extends Serializable {
	public void check(EJavaProject project) throws CheckerException;
}
