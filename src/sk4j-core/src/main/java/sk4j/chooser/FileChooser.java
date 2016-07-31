package sk4j.chooser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sk4j.console.Choosable;
import sk4j.console.ConsoleColor;

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

	public static List<FileChooser> asList(File... files) {
		//@formatter:off
		return Arrays.asList(files)
					.stream()
					.map(FileChooser::new)
					.collect(Collectors.toList());
		//@formatter:on
	}

}
