package sk4j.core;

import java.io.Serializable;
import java.util.List;

import sk4j.console.Selectable;

public interface OptionSelector<T extends Selectable<T>> extends Serializable {

	T selectOne(List<T> options);

	List<T> selectMany(List<T> options);
}
