package foo

import sk4j.SkTemplate

class DaoTemplate extends SkTemplate {

	@Override
	def template() {
		'''
		public class ${context.model.name}DAO {
		}
	'''
	}
}
