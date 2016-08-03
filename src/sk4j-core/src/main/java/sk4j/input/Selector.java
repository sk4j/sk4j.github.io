package sk4j.input;

import java.io.Serializable;
import java.util.List;

public interface Selector<T extends Selectable<T>> extends Serializable {

	T selectOne(List<T> options);

	List<T> selectMany(List<T> options);
}
