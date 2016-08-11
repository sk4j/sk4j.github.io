package sk4j.implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;

import javax.inject.Inject;

import sk4j.console.Colorize;
import sk4j.core.Context;
import sk4j.core.Log;
import sk4j.file.FS;
import sk4j.model.EPath;

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

	private final String CREATE_ID = Colorize.bold(Colorize.blue("[CREATE]"));

	private final String COPY_ID = Colorize.bold(Colorize.blue("[COPY]"));

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mkdir(EPath epath) throws IOException {
		Set<String> p;
		if (Files.notExists(epath.getPath())) {
			Files.createDirectories(epath.getPath());
			log.format("%s\t%s", CREATE_ID, Colorize.bold(Colorize.blue(epath.getPath().toString())));
			return;
		}
		log.format(Colorize.gray("[SKIP]\t%s. Diretório já existe."), epath.getPath().toString());
	}

	@Override
	public void copy(String source, EPath destination) throws IOException {
		source = context.replace(source);
		InputStream inputStream = this.getClass().getResourceAsStream(source);
		Path pdestination = destination.getPath();
		Files.copy(inputStream, pdestination);
		String sourceOut = Colorize.bold(Colorize.green(source));
		String detinationOut = Colorize.bold(Colorize.blue(destination.getPath().toString()));
		log.format("%s\t%s -> %s", COPY_ID, sourceOut, detinationOut);
	}

	@Override
	public void write(Path path, String content) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW);
		writer.write(content);
		writer.flush();
		writer.close();
		String pathOut = Colorize.bold(Colorize.blue(path.toFile().getAbsolutePath()));
		log.format("%s\t%s", CREATE_ID, pathOut);
	}

}
