package sk4j.core;

import java.awt.Desktop;
import java.net.URI;

import sk4j.core.console.CColor;

public class SkSystem {
	
	/**
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
}
