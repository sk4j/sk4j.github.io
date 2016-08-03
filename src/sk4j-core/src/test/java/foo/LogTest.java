package foo;

import sk4j.core.Log;
import sk4j.implementation.LogImpl;

public class LogTest {
	public static void main(String[] args) {
		Log log = new LogImpl();

		log.debug("Oi %s %s", "Jose", 1);
	}
}
