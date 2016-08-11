package foo;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.core.Context;
import sk4j.file.EPaths;
import sk4j.file.FS;

@RunWith(SK4JRunner.class)
public class FSMkdirTest {

	@Inject
	private FS fs;

	@Inject
	private Context context;

	@Test
	public void run() throws IOException {
		context.put("project", "aelis");
		fs.mkdir(EPaths.get("build/{{project}}/ativivdade"));
	}

}
