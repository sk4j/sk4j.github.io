package sk4j.console;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.core.Beans;
import sk4j.core.Context;

@RunWith(SK4JRunner.class)
public class ReaderTest {

	// @Inject
	// private Context context;

	// @Inject
	// @NotBlank
	// private StringReader daoName;

	@Test
	public void test() throws IOException {
		System.out.println("Iniciando");
		Context context = Beans.getReference(Context.class);
		context.put("Oi", "Aqui");
		System.out.println("Context: " + context);
		// daoName.read("Digite o nome do dao");
		// System.out.println(daoName.getValue());
		// System.out.println(context.getContext());
	}
}
