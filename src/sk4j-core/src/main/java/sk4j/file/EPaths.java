package sk4j.file;

import java.nio.file.Paths;

import sk4j.core.Beans;
import sk4j.core.Context;
import sk4j.implementation.EPathImpl;
import sk4j.model.EPath;

public class EPaths {

	public static EPath get(String pathName) {
		return new EPathImpl(Paths.get(Beans.getReference(Context.class).replace(pathName)));
	}
}
