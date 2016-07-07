package foo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import sk4j.core.input.OptionInputReader;
import sk4j.core.input.util.StringChooser;

public class OptionInputReaderTest {
	public static void main(String[] args) throws IOException {
		List<StringChooser> opts = Arrays.asList(new StringChooser("aaa"), new StringChooser("bbb"), new StringChooser("ccc"));
		
		OptionInputReader<StringChooser> p = new OptionInputReader<StringChooser>("Digite as opt1: ",opts);
		p.printOptions();
		
	}
}
