package sk4j.confirm;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import sk4j.bootstrap.SK4JRunner;
import sk4j.input.Selector;
import sk4j.task.Task1;

@RunWith(SK4JRunner.class)
public class ConfirmTest {

	@Inject
	private Task1 task1;

	@Inject
	private Selector selector;

	@Test
	public void init() throws IOException {
		selector.confirm("Deseja gerar DAO?", task1);
	}
}
