package sk4j.implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.core.FS;
import sk4j.core.Log;
import sk4j.exception.InvalidFileContentException;
import sk4j.exception.InvalidFileNameException;
import sk4j.exception.InvalidPathException;

/**
 * 
 * @author jcruz
 *
 */
public class FSImpl implements FS {

	@Inject
	private Log log;

	@Inject
	private Context context;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mkdir(String path) {
		path = context.replace(path);
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
			log.format("%s\t%s", Colorize.bold(Colorize.blue("[CREATE]")), Colorize.bold(Colorize.blue(dir.getAbsolutePath())));
			return;
		}
		log.format(Colorize.gray("[SKIP]\t%s. Diretório já existe."), dir.getAbsolutePath());
	}

	@Override
	public void createFile(String filePath, String fileName, String content) {
		if (StringUtils.isNotBlank(filePath)) {
			filePath = context.replace(filePath);
			fileName = context.replace(fileName);
			File file = new File(String.format("%s/%s", filePath, fileName));
			if (file.exists()) {
				log.format(Colorize.yellow("[SKIP]\t%s. Arquivo já existe."), file.getAbsolutePath());
				return;
			}
			write(file.toPath(), content);
		}
	}

	@Override
	public void copy(String source, String destination) {
		try {
			source = context.replace(source);
			destination = context.replace(destination);
			InputStream inputStream = this.getClass().getResourceAsStream(source);
			Path pdestination = Paths.get(destination);
			Files.copy(inputStream, pdestination);
		} catch (IOException e) {
			log.error(Colorize.red("Erro ao criar arquivo: %s"), e.getMessage());
			return;
		}
		log.format("%s\t%s -> %s", Colorize.bold(Colorize.blue("[COPY]")), Colorize.bold(Colorize.green(source)),
				Colorize.bold(Colorize.blue(destination)));
	}

	private void write(Path path, String content) {
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			log.error(Colorize.red("Erro ao criar arquivo: %s"), e.getMessage());
			return;
		}
		log.format("%s\t%s", Colorize.bold(Colorize.blue("[CREATE]")), Colorize.bold(Colorize.blue(path.toFile().getAbsolutePath())));
	}

	private void validatePath(String path) throws InvalidPathException {
		if (StringUtils.isBlank(path)) {
			throw new InvalidPathException("O caminho de diretório não pode ser vazio.");
		}
	}

	private void validateFileName(String name) throws InvalidFileNameException {
		if (StringUtils.isBlank(name)) {
			throw new InvalidFileNameException("O nome do arquivo não pode ser vazio.");
		}
	}

	private void validateFileContext(String content) throws InvalidFileContentException {
		if (StringUtils.isBlank(content)) {
			throw new InvalidFileContentException("O conteúdo do arquivo: %s não pode ser vazio.");
		}
	}
}
