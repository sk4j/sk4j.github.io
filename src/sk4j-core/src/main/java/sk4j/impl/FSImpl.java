package sk4j.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.console.ConsoleColor;

/**
 * 
 * @author jcruz
 *
 */
public class FSImpl implements FS {

	@Inject
	private Logger log;

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
			log.info("{}\t{}", ConsoleColor.bold(ConsoleColor.blue("[CREATE]")),
					ConsoleColor.bold(ConsoleColor.blue(removeProjectPath(dir.getAbsolutePath()))));
			return;
		}
		log.warn(ConsoleColor.gray("[SKIP]\t{}. Diretório já existe."), removeProjectPath(dir.getAbsolutePath()));
	}

	@Override
	public void createFile(String filePath, String fileName, String content) {
		if (StringUtils.isNotBlank(filePath)) {
			filePath = context.replace(filePath);
			fileName = context.replace(fileName);
			File file = new File(String.format("%s/%s", filePath, fileName));
			if (file.exists()) {
				log.warn(ConsoleColor.yellow("[SKIP]\t{}. Arquivo já existe."), removeProjectPath(file.getAbsolutePath()));
				return;
			}
			write(file.toPath(), content);
		}
	}

	private void write(Path path, String content) {
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			log.error(ConsoleColor.red("Erro ao criar arquivo: {}"), e.getMessage());
			return;
		}
		log.info("{}\t{}", ConsoleColor.bold(ConsoleColor.blue("[CREATE]")),
				ConsoleColor.bold(ConsoleColor.blue(removeProjectPath(path.toFile().getAbsolutePath()))));
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
			log.error(ConsoleColor.red("Erro ao criar arquivo: {}"), e.getMessage());
			return;
		}
		log.info("{}\t{} -> {}", ConsoleColor.bold(ConsoleColor.blue("[COPY]")), ConsoleColor.bold(ConsoleColor.green(source)),
				ConsoleColor.bold(ConsoleColor.blue(removeProjectPath(destination))));
	}

	@Override
	public String findSiblingPath(String base, String name, int parentDepth) {
		log.info(ConsoleColor.gray("Buscando diretório com nome [{}] no mesmo nivel de [{}]"), name, removeProjectPath(base));
		if (parentDepth > 0 && base != null) {
			File currentPath = new File(base);
			File parentPath = currentPath.getParentFile();
			File siblingPath = new File(String.format("%s/%s", parentPath.getAbsolutePath(), name));
			if (siblingPath.exists()) {
				log.info(ConsoleColor.gray("Diretório encontrado: {}"),
						(ConsoleColor.bold(removeProjectPath(siblingPath.getAbsolutePath()))));
				return siblingPath.getAbsolutePath();
			}
			return findSiblingPath(parentPath.getAbsolutePath(), name, parentDepth - 1);
		}
		return null;
	}

	private String removeProjectPath(String base) {
		return StringUtils.difference(context.getJavaProject().getPath(), base);
	}

}
