package sk4j.console;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.api.Console;
import sk4j.core.console.reader.ReadConf;
import sk4j.runner.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class ConsoleTestCase {

	@Inject
	private Console console;
	
	@Test
	public void test() {
		console.read("Oi", ReadConf.ALPHANUMERIC);
	}

}
