package sk4j.implementation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

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
		log.format("%s\t%s -> %s", COPY_ID, Colorize.bold(Colorize.green(source)),
				Colorize.bold(Colorize.blue(destination.getPath().toString())));
	}

	public void createFile(String filePath, String fileName, String content) {
		if (StringUtils.isNotBlank(filePath)) {
			filePath = context.replace(filePath);
			fileName = context.replace(fileName);
			File file = new File(String.format("%s/%s", filePath, fileName));
			if (file.exists()) {
				log.format(Colorize.yellow("[SKIP]\t%s. Arquivo já existe."), file.getAbsolutePath());
				return;
			}
			// write(file.toPath(), content);
		}
	}

}
