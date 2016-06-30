package sk4j.input

import groovy.transform.ToString;
import sk4j.ConsoleColor

class FileChooser implements Choosable<FileChooser> {

	private File file

	public FileChooser(File file) {
		super()
		this.file = file
	}

	@Override
	public int compareTo(FileChooser o) {
		return file.name.compareTo(o.file.name)
	}

	@Override
	public String getChoiseLabel() {
		def greenColor = ConsoleColor.GREEN.value
		def whiteColor = ConsoleColor.WHITE.value
		def bold = ConsoleColor.BOLD.value
		return "${bold}${this.file.name}${whiteColor} - ${greenColor}${file.absolutePath}${whiteColor}"
	}

	@Override
	public String toString() {
		return "FileChooser [file=" + file.absolutePath + "]";
	}
	
}
