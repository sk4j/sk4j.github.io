package sk4j.analyzer;

import javax.inject.Inject;

import sk4j.api.model.EJavaClass;
import sk4j.core.EntityAnalizer;
import sk4j.core.EntityReport;

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
	public void analyze(EJavaClass javaClass) {
		if (!javaClass.getJavaMethods().stream().anyMatch(method -> method.getName().equals("hashCode"))) {
			report.addReportItem(javaClass.getName(), "A classe deve implementar hashCode.");
		}
	}

}
