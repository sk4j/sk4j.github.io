package sk4j;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Iterator;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import sk4j.api.Browser;
import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.api.Template;
import sk4j.core.AfterStart;
import sk4j.core.EntityAnalizer;
import sk4j.core.EntityReport;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Instance<EntityAnalizer> analyzers;

	@Inject
	private Browser browser;

	@Inject
	private Context context;

	@Inject
	private EntityReport report;

	@Inject
	private FS fs;

	@Inject
	private Template template;

	public void run(@Observes AfterStart event) throws IOException {
		//@formatter:off
		context.getProject().getJavaFiles()
			.stream()
			.filter(javaFile -> javaFile.hasAnnotation("Entity"))
			.forEach(javaFile -> {
				analyzers.forEach(analizer -> analizer.analyze(javaFile));
		});
		//@formatter:on
		createHTMLReport();
	}

	private void createHTMLReport() throws MalformedURLException {
		context.putItem("report", report.getReportMultimap());
		fs.createFile("{{SK4J_HOME}}/tmp", "{{project.name}}-entity-analyzer.html", template.merge("/templates/entity-report-html.jtwig"));
		browser.open(new File(context.replace("{{SK4J_HOME}}/tmp/{{project.name}}-entity-analyzer.html")).toURI().toURL().toString());
	}
}