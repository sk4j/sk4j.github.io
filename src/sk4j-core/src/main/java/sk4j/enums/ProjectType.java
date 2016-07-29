package sk4j.enums;

import sk4j.api.Checker;
import sk4j.impl.checker.GradleProjectChecker;
import sk4j.impl.checker.MavenProjectChecker;

public enum ProjectType {

	MAVEN(MavenProjectChecker.class), GRADLE(GradleProjectChecker.class);

	private Class<? extends Checker> checker;

	private ProjectType(Class<? extends Checker> checker) {
		this.checker = checker;
	}

	public Class<? extends Checker> getChecker() {
		return checker;
	}

}
