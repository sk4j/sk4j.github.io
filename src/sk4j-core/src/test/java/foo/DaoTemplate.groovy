package foo

import sk4j.Template

class DaoTemplate extends Template {


	@Override
	public String outputPath() {
		return "${context.model.path}/../persistence/${context.model.name}DAO1.java"
	}

	@Override
	def template() {
		'''
		public class ${context.model.name}DAO {
		}
	'''
	}
}
