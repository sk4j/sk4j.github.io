package sk4j

import sk4j.model.EJavaFile
/**
 * Classe que armazena os resultados de uma analise em determinada classe.
 * 
 * @author jcruz
 *
 */
class JavaFileAnalyzerResult {
	EJavaFile javaFile

	/**
	 * Resultados relativo a classe.
	 */
	List<String> results = [];
}
