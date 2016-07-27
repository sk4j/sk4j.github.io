package sk4j.api.model;

import sk4j.core.console.Choosable;

public interface EJavaPackage extends Choosable<EJavaPackage> {

	String getName();

	String getPath();

	@Override
	default int compareTo(EJavaPackage o) {
		return 0;
	}

	@Override
	default String getChoiseLabel() {
		return null;
	}

}
