package foo.delegate;

import sk4j.core.SkApp;
import sk4j.core.SkSystem;

public class FooDelegateApp extends SkApp {
	public static void main(String[] args) {
		new FooDelegateApp().start(args);
	}

	@Override
	protected void run() throws Exception {
		System.out.println("0000");
		SkSystem.process(FooDelegate.class);
	}
}
