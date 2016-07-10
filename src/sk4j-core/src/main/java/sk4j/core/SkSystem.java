package sk4j.core;

import java.awt.Desktop;
import java.net.URI;

import sk4j.core.console.CColor;

public class SkSystem {

	/**
	 * Sai da aplicação com uma mensagem de erro.
	 * 
	 * @param message
	 */
	public static void exit(String message) {
		System.out.println("");
		System.out.println("**************************************");
		System.out.println(CColor.red(message));
		System.exit(1);
	}

	/**
	 * Abre o navegador com a URL especificada.
	 * 
	 * @param url
	 */
	public static void browser(String url) {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI(url));
		} catch (Exception e) {
			exit("Erro ao abrir o navegador.");
		}
	}

	/**
	 * 
	 * @param processorClass
	 */
	public static <T extends DelegateProcessor> void process(Class<T> processorClass) {
		try {
			DelegateProcessor processor = processorClass.newInstance();
			processor.process();
		} catch (InstantiationException | IllegalAccessException e) {
			exit(e.getMessage());
		}

	}
}
