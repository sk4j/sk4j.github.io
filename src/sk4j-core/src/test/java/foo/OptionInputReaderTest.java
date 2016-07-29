package foo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import sk4j.console.reader.OptionInputReader;
import sk4j.utils.StringChooser;

public class OptionInputReaderTest {
	public static void main(String[] args) throws IOException {
		List<StringChooser> opts = Arrays.asList(new StringChooser(1,"aaa"), new StringChooser(2,"bbb"), new StringChooser(3,"ccc"));
		
		OptionInputReader<StringChooser> p = new OptionInputReader<StringChooser>("Digite as opt1: ",opts);
		p.printOptions();
		
	}
}
