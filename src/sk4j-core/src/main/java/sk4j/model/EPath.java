package sk4j.model;

import java.nio.file.Path;

import sk4j.input.Selectable;

public interface EPath extends Selectable<EPath> {

	Path getPath();

	@Override
	default int compareTo(EPath o) {
		return getPath().compareTo(o.getPath());
	}

	@Override
	default String getSelectLabel() {
		return getPath().toString();
	}

}
