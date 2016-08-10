package sk4j.console;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.FooName;
import sk4j.bootstrap.SK4JRunner;
import sk4j.core.Context;
import sk4j.input.Reader;

@RunWith(SK4JRunner.class)
public class ReaderTest {

	@Inject
	private Context context;

	// @Inject
	// @NotBlank
	// private StringReader daoName;

	@Inject
	private Reader reader;

	@Inject
	private FooName fooName;

	@Test
	public void test() throws IOException {
		reader.read("Digite o nome do foo", "fooNameDao", fooName);
		System.out.println(fooName.getValue());
		System.out.println(context);
		// daoName.read("Digite o nome do dao");
		// System.out.println(daoName.getValue());
		// System.out.println(context.getContext());
	}
}
