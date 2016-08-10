package sk4j.task;

import sk4j.annotation.TaskConf;
import sk4j.core.Task;

@TaskConf(label = "Gerar DAO", order = 1)
public class Task2 implements Task {

	@Override
	public void run() {
		System.out.println("Executando Task2...");
	}

}
