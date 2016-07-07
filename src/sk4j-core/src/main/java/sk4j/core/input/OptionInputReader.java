package sk4j.core.input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OptionInputReader extends InputReader {

	private List<? extends Choosable<?>> options = new ArrayList<>();

	public OptionInputReader(String label, List<? extends Choosable<?>> options) {
		super(label);
		this.options = options;
	}

	public void printOptions() {
		AtomicInteger index = new AtomicInteger();
		//@formatter:off
		options
			.stream()
			.map(opt -> String.format("%d > %s", index.incrementAndGet(), opt.getChoiseLabel()))
			.forEach(System.out::println);
		//@formatter:on
	}
}
