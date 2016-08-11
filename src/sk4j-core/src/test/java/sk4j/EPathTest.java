package sk4j;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.file.EPaths;
import sk4j.model.EPath;

@RunWith(SK4JRunner.class)
public class EPathTest {

	@Test
	public void init() throws IOException {
		EPath epath = EPaths
				.get("/home/jcruz/Programs/eclipse-mars/workspace/aelis2016/src/main/java/br/jus/tre_pa/aelis/atividades/domain");

		epath.siblings().stream().forEach(System.out::println);
	}
}
