package sk4j.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;

import org.slf4j.Logger;

import sk4j.api.FS;

/**
 * 
 * @author jcruz
 *
 */
public class FSImpl implements FS {

	@Inject
	private Logger log;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mkdir(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
			log.info("Diretório criado: {}", dir.getAbsolutePath());
			return;
		}
		log.warn("Diretório já existe: {}", dir.getAbsolutePath());
	}

	@Override
	public void createFile(Path filePath, String fileName, String content) throws IOException {
		File file = new File(String.format("%s/%s", filePath.toFile().getAbsolutePath(), fileName));
		if (file.exists()) {
			log.warn("Arquivo já existe: {}", file.getAbsolutePath());
			return;
		}
		write(file.toPath(), content);
	}

	private void write(Path path, String content) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(path);
		writer.write(content);
		writer.flush();
		writer.close();
		log.info("Arquivo criado: {}", path.toFile().getAbsolutePath());
	}

}
