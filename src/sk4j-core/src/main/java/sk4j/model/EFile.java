package sk4j.model;

import java.io.File;

import sk4j.console.Colorize;
import sk4j.input.api.Selectable;

public interface EFile extends Selectable<EFile> {

	File getFile();

	@Override
	default int compareTo(EFile o) {
		return getFile().getName().compareTo(o.getFile().getName());
	}

	@Override
	default String getSelectLabel() {
		return Colorize.bold(getFile().getName()) + " - " + Colorize.gray(getFile().getAbsolutePath());
	}

}
