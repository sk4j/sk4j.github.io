package sk4j.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sk4j.file.EPaths;
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

	@Override
	public Optional<EPath> sibling(String name) {
		return Optional.empty();
	}

	@Override
	public SortedSet<EPath> siblings() throws IOException {
		//@formatter:off
		return Files.walk(this.path.getParent(), 1)
					.filter(p -> p.toFile().isDirectory() && p.compareTo(this.path.getParent()) != 0 && p.compareTo(this.path) != 0 )
					.map(p -> EPaths.get(p))
					.collect(Collectors.toCollection(TreeSet::new));
		//@formatter:on
	}

	@Override
	public String toString() {
		return "EPathImpl [path=" + path + "]";
	}

}
