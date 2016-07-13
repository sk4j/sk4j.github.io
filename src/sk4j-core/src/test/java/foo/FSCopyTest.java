package foo;

import javax.inject.Inject;

import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.core.MainApp;

public class FSCopyTest extends MainApp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private Context ctx;

	public static void main(String[] args) throws Exception {
		new FSCopyTest().init(args);
	}

	@Override
	public void run() throws Exception {
		fs.copy("/files/readme.txt", "/home/jcruz/git/sk4j.github.io/src/sk4j-core/build/readme.txt");
	}
}
