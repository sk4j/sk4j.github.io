package sk4j.core.input.util;

import java.io.File;

import sk4j.core.input.Choosable;

public class FileChooser implements Choosable<FileChooser> {

	private File file;

	public FileChooser(File file) {
		super();
		this.file = file;
	}

	@Override
	public int compareTo(FileChooser o) {
		return file.getName().compareTo(o.getFile().getName());
	}

	@Override
	public String getChoiseLabel() {
		return file.getName();
	}

	public File getFile() {
		return file;
	}

}
