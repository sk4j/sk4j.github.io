package sk4j.implementation;

import java.io.File;

import sk4j.model.EFile;

public class EFileImpl implements EFile {

	private File file;

	public EFileImpl(File file) {
		super();
		this.file = file;
	}

	@Override
	public File getFile() {
		return this.file;
	}

}
