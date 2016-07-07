package foo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import sk4j.core.exception.InvalidOptionException;
import sk4j.core.input.MultipleOptionInputReader;
import sk4j.core.input.util.StringChooser;

public class MultipleOptionInputReaderTest {
	public static void main(String[] args) throws IOException, InvalidOptionException {
		List<StringChooser> opts = Arrays.asList(new StringChooser("aaa"), new StringChooser("bbb"), new StringChooser("ccc"));
		
		MultipleOptionInputReader<StringChooser> p = new MultipleOptionInputReader<StringChooser>("Digite as opt1: ",opts);
		p.readOptions();
		
	}
}
