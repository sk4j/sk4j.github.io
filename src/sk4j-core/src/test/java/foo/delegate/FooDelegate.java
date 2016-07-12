package foo.delegate;

import sk4j.core.DelegateProcessor;

public class FooDelegate implements DelegateProcessor {

	@Override
	public void process() {
		System.out.println("Foo Delegate!!!");
	}

}
