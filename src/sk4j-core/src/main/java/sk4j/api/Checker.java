package sk4j.api;

import java.io.Serializable;

import sk4j.api.model.EJavaProject;
import sk4j.exception.RequiredJavaProjectException;

public interface Checker extends Serializable {
	public void check(EJavaProject project) throws RequiredJavaProjectException;
}
