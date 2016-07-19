package sk4j.analyzer;

import javax.inject.Inject;

import sk4j.core.EntityAnalizer;
import sk4j.core.EntityReport;
import sk4j.core.model.EJavaFile;

/**
 * Verifica se a entidade implementa o hashCode.
 * 
 * @author jcruz
 *
 */
public class EntityHasHashCodeAnalyzer implements EntityAnalizer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityReport report;

	@Override
	public void analyze(EJavaFile javaFile) {
		if (!javaFile.getJavaMethods().stream().anyMatch(method -> method.getName().equals("hashCode"))) {
			report.addReportItem(javaFile.getName(), "A classe deve implementar hashCode.");
		}
	}

}
