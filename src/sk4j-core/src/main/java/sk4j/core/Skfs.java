package sk4j.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import sk4j.core.console.CColor;
import sk4j.core.console.SkConsole;

/**
 * Classe responsável por operações no sistema de arquivos.
 * 
 * @author jcruz
 *
 */
public class Skfs {

	/**
	 * Cria um diretório.
	 * 
	 * @param path
	 */
	public static void mkdir(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
			SkConsole.log("%s Diretório criado: %s", CColor.cyan(">>>"), dir.getAbsolutePath());
			return;
		}
		SkConsole.log("Diretório existente: %s", dir.getAbsolutePath());
	}

	/**
	 * 
	 * @param filePath
	 * @param fileName
	 * @param template
	 * @throws IOException
	 */
	public static void createFile(Path filePath, String fileName, SkTemplate template) throws IOException {
		createFile(filePath, fileName, template.merge());
	}

	/**
	 * 
	 * @param filePath
	 * @param fileName
	 * @param content
	 * @throws IOException
	 */
	public static void createFile(Path filePath, String fileName, String content) throws IOException {
		File file = new File(String.format("%s/%s", filePath.toFile().getAbsolutePath(), fileName));
		if (file.exists()) {
			SkConsole.log("Arquivo existente: %s/%s", filePath.toFile().getAbsolutePath(), fileName);
			return;
		}
		new Skfs().write(file.toPath(), content);
	}

	/**
	 * 
	 * @param path
	 * @param content
	 * @throws IOException
	 */
	private void write(Path path, String content) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(path);
		writer.write(content);
		writer.flush();
		writer.close();
		SkConsole.log("%s Arquivo criado:   %s", CColor.cyan(">>>"), path.toFile().getAbsolutePath());
	}

}
