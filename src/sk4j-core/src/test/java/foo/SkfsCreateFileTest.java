package foo;

import java.io.IOException;
import java.nio.file.Paths;

import sk4j.core.Skfs;

public class SkfsCreateFileTest {

	public static void main(String[] args) throws IOException {
		Skfs.mkdir("build/abc");
		Skfs.createFile(Paths.get("build/abc"), "Test.java", "Hello World!");
	}

}
