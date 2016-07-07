package foo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import sk4j.core.exception.InvalidOptionException;
import sk4j.core.input.SingleOptionInputReader;
import sk4j.core.input.StringChooser;

public class SingleOptionInputReaderTest {
	public static void main(String[] args) throws IOException, InvalidOptionException {
		List<StringChooser> opts = Arrays.asList(new StringChooser("aaa"), new StringChooser("bbb"), new StringChooser("ccc"));
		
		SingleOptionInputReader<StringChooser> p = new SingleOptionInputReader<StringChooser>("Digite as opt1: ",opts);
		p.readOption();
		
	}
}
