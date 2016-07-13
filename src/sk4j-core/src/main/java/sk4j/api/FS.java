package sk4j.api;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
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
	 * 
	 * @param source
	 * @param destination
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	void copy(String source, String destination) throws URISyntaxException, IOException;

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
	void createFile(Path filePath, String fileName, String content) throws IOException;

}
