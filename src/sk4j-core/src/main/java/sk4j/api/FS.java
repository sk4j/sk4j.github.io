package sk4j.api;

import java.io.Serializable;
import java.nio.file.Path;

/**
 * Classe responsável manipular o sistema de arquivos.
 * 
 * @author jcruz
 *
 */
public interface FS extends Serializable {

	/**
	 * Cria um diretório no caminho especificado.
	 * 
	 * @param path
	 */
	void mkdir(String path);

	/**
	 * Cria um arquivo com o modelo de template.
	 * 
	 * @param filePath
	 *            Caminho do arquivo.
	 * @param fileName
	 *            Nome do arquivo.
	 * @param template
	 *            Template
	 */
	void createFile(Path filePath, String fileName, Template template);

	/**
	 * Cria um arquivo com o conteudo passado pela String.
	 * 
	 * @param filePath
	 *            Caminho do arquivo.
	 * @param fileName
	 *            Nome do arquivo.
	 * @param content
	 *            Conteúdo do arquivo.
	 */
	void createFile(Path filePath, String fileName, String content);

}
