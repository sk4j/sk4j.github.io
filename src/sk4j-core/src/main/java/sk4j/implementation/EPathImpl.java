package sk4j.implementation;

import java.nio.file.Path;

import sk4j.model.EPath;

public class EPathImpl implements EPath {

	private Path path;

	public EPathImpl(Path path) {
		super();
		this.path = path;
	}

	@Override
	public Path getPath() {
		return this.path;
	}

}
