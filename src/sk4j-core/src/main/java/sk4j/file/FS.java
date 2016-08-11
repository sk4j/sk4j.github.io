package sk4j.file;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;

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
	 *            Caminho do diretório.
	 * @throws IOException
	 */
	void mkdir(EPath epath) throws IOException;

	/**
	 * Copia um arquivo do diretório source para o diretório de destino
	 * 
	 * @param source
	 *            Caminho fonte no classapth
	 * @param destination
	 *            Caminho de destino no sistema de arquivos.
	 * @throws IOException
	 */
	void copy(String source, EPath epathDestination) throws IOException;

	/**
	 * 
	 * @param path
	 * @param content
	 * @throws IOException
	 */
	public void write(Path path, String content) throws IOException;

}
