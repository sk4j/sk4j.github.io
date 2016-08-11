package sk4j.file;

import java.io.IOException;
import java.io.Serializable;

import sk4j.model.EPath;

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
	 * @throws IOException
	 */
	void mkdir(EPath epath) throws IOException;

	/**
	 * Copia um arquivo do diretório source para o diretório de destino
	 * 
	 * @param source
	 * @param destination
	 * @throws IOException
	 */
	void copy(String source, EPath epathDestination) throws IOException;
}
