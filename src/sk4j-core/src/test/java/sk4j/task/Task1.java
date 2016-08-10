package sk4j.task;

import sk4j.annotation.TaskConf;
import sk4j.core.Task;

@TaskConf(label = "Gerar DAO e BC", order = 2)
public class Task1 implements Task {

	@Override
	public void run() {
		System.out.println("Executando Task1");
	}

}
