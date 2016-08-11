package sk4j.model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.SortedSet;

import sk4j.input.Selectable;

/**
 * Representa um caminho no sistema de arquivos.
 * 
 * @author jcruz
 *
 */
public interface EPath extends Selectable<EPath> {

	/**
	 * Objecto do tipo Path.
	 * 
	 * @return java.nio.file.Path.Path do java.
	 */
	Path getPath();

	/**
	 * Retorna o caminho irmão do nó atual com o nome correspondente
	 * 
	 * 
	 * @param name
	 * @return
	 */
	Optional<EPath> sibling(String name);

	SortedSet<EPath> siblings() throws IOException;

	@Override
	default int compareTo(EPath o) {
		return getPath().compareTo(o.getPath());
	}

	@Override
	default String getConsoleLabel() {
		return getPath().toString();
	}

}
