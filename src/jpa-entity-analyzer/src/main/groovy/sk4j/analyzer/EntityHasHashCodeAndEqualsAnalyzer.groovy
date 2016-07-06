package sk4j.analyzer

import sk4j.DelegateProcessor
import sk4j.model.EJavaFile
import sk4j.model.EJavaMethod

/**
 * Analisa se a classe possui as implementações de hashCode and equals.
 * 
 * @author jcruz
 *
 */
class EntityHasHashCodeAndEqualsAnalyzer extends DelegateProcessor {

	@Override
	public void execute() {
		EJavaFile javaFile = context['javaFileAnalyzerResult'].javaFile

		def hashCode = javaFile.javaMethods.any { EJavaMethod m -> m.name.equals("hashCode") }
		def equals = javaFile.javaMethods.any { EJavaMethod m -> m.name.equals("equals") }

		if(!hashCode) {
			context['javaFileAnalyzerResult'].results << "A classe ${javaFile.name} deve implementar hashCode."
		}
		if(!equals) {
			context['javaFileAnalyzerResult'].results << "A classe ${javaFile.name} deve implementar equals."
		}
	}
}
