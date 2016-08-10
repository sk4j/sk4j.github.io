package sk4j.task;

import sk4j.input.annotation.TaskConf;
import sk4j.input.api.Task;

@TaskConf(label = "Gerar DAO", order = 1)
public class Task2 implements Task {

	@Override
	public void run() {
		System.out.println("Executando Task2...");
	}

}
