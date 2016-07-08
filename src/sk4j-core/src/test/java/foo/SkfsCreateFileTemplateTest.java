package foo;

import java.io.IOException;
import java.nio.file.Paths;

import sk4j.core.SkContext;
import sk4j.core.SkTemplates;
import sk4j.core.Skfs;

public class SkfsCreateFileTemplateTest {

	public static void main(String[] args) throws IOException {
		Skfs.mkdir("build/abc");
		SkContext.get().putItem("name", "José Ribamar");
		Skfs.createFile(Paths.get("build/abc"), "Test.java", SkTemplates.get("test"));
	}

}
