package sk4j.impl.checker;

import sk4j.api.Checker;
import sk4j.api.model.EJavaProject;
import sk4j.exception.RequiredJavaProjectException;

public class MavenProjectChecker implements Checker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void check(EJavaProject project) throws RequiredJavaProjectException {
		if (!project.isMavenProject()) {
			throw new RequiredJavaProjectException("O diretório não possui um projeto Maven.");
		}
	}

}
