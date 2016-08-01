package sk4j.core;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

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
	 * 
	 * @param source
	 * @param destination
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	void copy(String source, String destination);

	/**
	 * Cria um arquivo com o conteudo passado pela String.
	 * 
	 * @param filePath
	 *            Caminho do arquivo.
	 * @param fileName
	 *            Nome do arquivo.
	 * @param content
	 *            Conteúdo do arquivo.
	 * @throws IOException
	 */
	void createFile(String filePath, String fileName, String content);


	/**
	 * 
	 * @param base
	 * @param name
	 * @return
	 */
	String findSiblingPath(String base, String name, int parentDepth);

}
