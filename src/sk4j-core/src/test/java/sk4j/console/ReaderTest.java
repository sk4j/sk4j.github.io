package sk4j.console;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.core.Context;
import sk4j.input.Reader;
import sk4j.input.annotation.ReaderConf;
import sk4j.runner.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class ReaderTest {

	@Inject
	@ReaderConf(message = "Digite o nome do dao")
	private Reader daoNameReader;

	@Inject
	private Context context;

	@Test
	public void test() throws IOException {
		daoNameReader.read();
		System.out.println(context);
	}

}
