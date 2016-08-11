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
	public Optional<EPath> getParent() {
		return this.path.getParent() != null ? Optional.of(EPaths.get(this.path.getParent())) : Optional.empty();
	}

	@Override
	public Optional<EPath> getSibling(String name) throws IOException {
		if (path.getParent() != null) {
			for (EPath epath : getSiblings()) {
				if (epath.getPath().endsWith(name)) {
					return Optional.of(epath);
				}
			}
		}
		return Optional.empty();
	}

	@Override
	public SortedSet<EPath> getSiblings() throws IOException {
		if (this.path.getParent() != null) {
			//@formatter:off
			return Files.walk(this.path.getParent(), 1)
					.filter(p -> p.toFile().isDirectory() && p.compareTo(this.path.getParent()) != 0 && p.compareTo(this.path) != 0 )
					.map(p -> EPaths.get(p))
					.collect(Collectors.toCollection(TreeSet::new));
			//@formatter:on
		}
		return new TreeSet<>();
	}

	@Override
	public String toString() {
		return "EPathImpl [path=" + path + "]";
	}

}
