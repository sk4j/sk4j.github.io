package sk4j.file;

import java.io.IOException;
import java.io.Serializable;

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
	 * Copia um arquivo do diretório source para o diretório de destino
	 * 
	 * @param source
	 * @param destination
	 * @throws IOException
	 */
	void copy(String source, String destination) throws IOException;
}
