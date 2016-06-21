package sk4j.generator.template

import sk4j.SkTemplate

class DaoGeneratorTemplate extends SkTemplate {

	@Override
	public String template() {
		'''
package ${model.parentPackageName}.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import ${model.javaClass.package.name}.${model.name};

@PersistenceController
public class ${model.name}DAO extends JPACrud<${model.name}, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
'''
	}
}
