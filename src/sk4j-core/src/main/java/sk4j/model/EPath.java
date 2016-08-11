package sk4j.model;

import java.nio.file.Path;

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

	@Override
	default int compareTo(EPath o) {
		return getPath().compareTo(o.getPath());
	}

	@Override
	default String getConsoleLabel() {
		return getPath().toString();
	}

}
