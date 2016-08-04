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
	private Reader fileNameReader;

	@Inject
	@ReaderConf(message = "Deseja criar o arquivo {{fileName}}?", confirmationMode = true)
	private Reader daoNameReader;

	@Inject
	private Context context;

	@Test
	public void test() throws IOException {
		fileNameReader.read();
		System.out.println(context);
		daoNameReader.read();
		System.out.println(context);
	}

}
