package sk4j.core;

import java.io.File;
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

	public static void createFile(Path filePath, String fileName, SkTemplate template) {
		File file = new File(String.format("%s/%s", filePath.toFile().getAbsolutePath(), fileName));
		if (file.exists()) {
			SkConsole.log("Arquivo existente: ");
		}
	}

}
