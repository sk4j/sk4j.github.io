package sk4j.implementation;

import java.awt.Desktop;
import java.net.URI;

import sk4j.console.Colorize;
import sk4j.core.Browser;

public class BrowserImpl implements Browser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void open(String url) {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI(url));
		} catch (Exception e) {
			System.out.println(Colorize.red("Erro ao abrir o navegador."));
		}
	}

}
