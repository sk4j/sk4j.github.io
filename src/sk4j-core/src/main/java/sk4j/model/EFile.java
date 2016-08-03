package sk4j.model;

import java.io.File;

import sk4j.console.ConsoleColor;
import sk4j.console.ConsoleSelectable;

public interface EFile extends ConsoleSelectable<EFile> {

	File getFile();

	@Override
	default int compareTo(EFile o) {
		return getFile().getName().compareTo(o.getFile().getName());
	}

	@Override
	default String getSelectLabel() {
		return ConsoleColor.bold(getFile().getName()) + " - " + ConsoleColor.gray(getFile().getAbsolutePath());
	}

}
