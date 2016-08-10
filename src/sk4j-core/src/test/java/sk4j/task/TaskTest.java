package sk4j.task;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.core.Task;
import sk4j.input.Selector;

@RunWith(SK4JRunner.class)
public class TaskTest {

	@Inject
	private Instance<Task> tasks;

	@Inject
	private Selector selector;

	@Test
	public void init() throws IOException {
		selector.selectAndExecuteMany("Selecione", tasks);
	}
}
