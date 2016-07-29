package sk4j.runner;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.api.Checker;

@RunWith(WeldJUnit4Runner.class)
@Ignore
public class CheckerTest {

	@Inject
	private Map<String, Checker> checkersMap;

	@Test
	public void tets() {
		checkersMap.forEach((k, v) -> System.out.println(k));
	}

}
