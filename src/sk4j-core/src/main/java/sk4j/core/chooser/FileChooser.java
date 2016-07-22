package sk4j.core.chooser;

import java.io.File;

import sk4j.core.console.Choosable;
import sk4j.core.console.ConsoleColor;

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
		return file.getName().concat(" - ").concat(ConsoleColor.gray(file.getAbsolutePath()));
	}

	public File getFile() {
		return file;
	}

}
