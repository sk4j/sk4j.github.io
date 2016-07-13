package sk.sk4j;

import java.io.IOException;

import javax.inject.Inject;

import sk4j.api.Context;
import sk4j.api.FS;
import sk4j.core.MainApp;

public class SkGeneratorApp extends MainApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FS fs;

	@Inject
	private Context ctx;

	public static void main(String[] args) throws Exception {
		new SkGeneratorApp().init(args);
	}

	@Override
	protected void beforeRun() throws IOException {

	}

	@Override
	public void run() {
		ctx.putItem("projectDir", ctx.replace("${sk4jSdkHome}/src/${projectName}"));

		fs.mkdir("${projectDir}");
		fs.mkdir("${projectDir}/src/main/java");
		fs.mkdir("${projectDir}/src/main/java/sk4j");
		fs.mkdir("${projectDir}/src/main/resources/templates");
		fs.mkdir("${projectDir}/src/main/resources/META-INF");
		fs.mkdir("${projectDir}/bin");
		fs.mkdir("${projectDir}/build");

	}
}
