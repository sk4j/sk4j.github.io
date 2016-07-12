package sk4j.impl;

import java.awt.Desktop;
import java.net.URI;

import javax.inject.Inject;

import sk4j.api.Browser;
import sk4j.api.Console;

public class BrowserImpl implements Browser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Console console;

	@Override
	public void open(String url) {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI(url));
		} catch (Exception e) {
			console.exit("Erro ao abrir o navegador.");
		}
	}

}
