package sk4j

import org.jtwig.JtwigTemplate

/**
 * 
 * Utilitários de Filesystem 
 *  
 * @author jcruz
 *
 */
class Skfs {
	
	/**
	 *
	 */
	def context = [:]
	
	/**
	 * 
	 */
	SkConsole console = new SkConsole()
	/**
	 *
	 * Cria um diretório.
	 *
	 * @param path. Caminho do diretório.
	 *
	 */
	def mkdir(String path) {
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value
		File dir = new File(path)
		if(!dir.exists()) {
			dir.mkdirs()
			console.echo "${cyanColor}>>>${console.whiteColor} Criando diretório:  ${dir.absolutePath}"
			return
		}
		console.echo "${cyanColor}>>> ${grayColor}Diretório existente: ${dir.absolutePath}${console.whiteColor}"
	}

	/**
	 * Cria um arquivo.
	 *
	 * @param params. Mapa com os parâmetros de criação do arquivo. Chaves do mapa:
	 * 		  path: String = Caminho do arquivo.
	 * 		  name: String = Nome do arquivo.
	 * 		  template: String = Nome do template localizado.
	 * 		  model: Chooseble = Modelo utilizando no template.
	 * 		  content: String = Conteúdo do arquivo. Não processa os paramentros template nem model.
	 *
	 */
	def createFile(params) {
		def cyanColor = ConsoleColor.CYAN.value
		def grayColor = ConsoleColor.GRAY.value
		File file = new File("${params.path}/${params.name}")
		if(file.exists()) {
			console.echo "${cyanColor}>>> ${grayColor}Arquivo existente:  ${params.path}/${params.name}${console.whiteColor}"
			return
		}
		console.echo "${cyanColor}>>>${console.whiteColor} Criando arquivo:    ${params.path}/${params.name}"
		if(params.content) {
			file << params.content
			return
		}
		this.context['model'] = params.model
		SkTemplate sktemplate =	new SkTemplate(template: JtwigTemplate.classpathTemplate("/templates/${params.template}.jtwig"), context: this.context)
		file << sktemplate.merge()
	}

}