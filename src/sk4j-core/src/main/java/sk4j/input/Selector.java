package sk4j.input;

import java.io.Serializable;
import java.util.List;

public interface Selector<T extends Selectable<T>> extends Serializable {

	T selectOne(List<T> selectableOptions);

	List<T> selectMany(List<T> selectableOptions);
}
