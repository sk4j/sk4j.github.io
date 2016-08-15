package sk4j.template;

import java.io.IOException;
import java.io.Serializable;

import sk4j.model.EPath;

/**
 * 
 * @author jcruz
 *
 */
public interface Template extends Serializable {

	/**
	 * 
	 * Mescla o arquivo de template com as variáveis do contexto.
	 * 
	 * @param templateName
	 *            Nome do template.
	 * @return Dados mesclados.
	 */
	String merge(String templateName);

	/**
	 * Mescla o arquivo de template com as variáveis do contexto gerando o arquivo correpondente.
	 * 
	 * @param templateName
	 *            Nome do template.
	 * @param path
	 *            Caminho do arquivo.
	 * @throws IOException
	 */
	void mergeAndCreateFile(String templateName, EPath epath) throws IOException;
}
