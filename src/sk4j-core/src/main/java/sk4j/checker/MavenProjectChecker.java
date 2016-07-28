package sk4j.checker;

import sk4j.api.model.EJavaProject;
import sk4j.core.Checker;
import sk4j.core.CheckerException;

public class MavenProjectChecker implements Checker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void check(EJavaProject project) throws CheckerException {
		if (!project.isMavenProject()) {
			throw new CheckerException("O diretório não possui um projeto Maven.");
		}
	}

}
