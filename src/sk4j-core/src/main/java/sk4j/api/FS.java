package sk4j.api;

import java.nio.file.Path;

/**
 * Classe responsável manipular o sistema de arquivos.
 * 
 * @author jcruz
 *
 */
public interface FS {

	/**
	 * Cria um diretório no caminho especificado.
	 * 
	 * @param path
	 */
	public void mkdir(String path);

	/**
	 * Cria um arquivo com o modelo de template.
	 * 
	 * @param filePath
	 *            Caminho do arquivo.
	 * @param fileName
	 *            Nome do arquivo.
	 * @param template Template 
	 */
	public void createFile(Path filePath, String fileName, Template template);

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
	public void createFile(Path filePath, String fileName, String content);

}
