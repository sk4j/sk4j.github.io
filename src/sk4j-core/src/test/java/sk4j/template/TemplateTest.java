package sk4j.template;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.core.Context;
import sk4j.file.EPaths;

@RunWith(SK4JRunner.class)
public class TemplateTest {

	@Inject
	private Template template;

	@Inject
	private Context context;

	@Test
	public void init() throws IOException {
		context.put("name", "José Ribamar Monteiro da Cruz");
		template.mergeAndCreateFile("test", EPaths.get("build/aelis/hello.txt"));
	}
}
