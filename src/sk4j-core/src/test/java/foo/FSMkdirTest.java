package foo;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import sk4j.file.FS;

public class FSMkdirTest {

	@Inject
	private FS fs;

	public void run() {
		fs.mkdir("build/abc-weld-test");
	}

	public static void main(String[] args) {
		Weld weld = new Weld();

		WeldContainer container = weld.initialize();

		FSMkdirTest app = container.instance().select(FSMkdirTest.class).get();

		app.run();

		weld.shutdown();
	}

}
