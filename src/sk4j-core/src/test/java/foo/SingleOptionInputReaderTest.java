package foo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import sk4j.core.chooser.StringChooser;
import sk4j.core.console.reader.SingleOptionInputReader;

public class SingleOptionInputReaderTest {
	public static void main(String[] args) throws IOException {
		List<StringChooser> opts = Arrays.asList(new StringChooser("aaa"), new StringChooser("bbb"), new StringChooser("ccc"));

		SingleOptionInputReader<StringChooser> p = new SingleOptionInputReader<StringChooser>("Digite as opt1: ", opts);
		p.readOption();

	}
}
