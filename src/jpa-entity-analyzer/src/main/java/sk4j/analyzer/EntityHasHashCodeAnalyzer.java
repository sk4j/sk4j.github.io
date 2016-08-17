package sk4j.analyzer;

import java.util.List;

import javax.inject.Inject;

import sk4j.annotation.Analyzer;
import sk4j.annotation.TaskConf;
import sk4j.core.Context;
import sk4j.core.Task;
import sk4j.model.EJavaClass;

@Analyzer
@TaskConf(label = "Verificar a existencia do hashCode.")
public class EntityHasHashCodeAnalyzer implements Task {

	@Inject
	private Context context;

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		List<EJavaClass> entities = (List<EJavaClass>) context.get("entities");
		// System.out.println(EntityHasHashCodeAnalyzer.class.getName());
		// System.out.println(entities);
	}

}
