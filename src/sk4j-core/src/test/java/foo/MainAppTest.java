package foo;

import sk4j.core.MainApp;

public class MainAppTest extends MainApp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		new MainAppTest().init(args);
	}

	@Override
	public void run() throws Exception {
		System.out.println("Oi");
	}
}
