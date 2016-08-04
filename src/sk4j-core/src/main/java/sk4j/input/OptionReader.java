package sk4j.input;

import java.io.Serializable;
import java.util.List;

public interface OptionReader extends Serializable {

	<T extends Selectable<T>> T selectOne(List<T> selectableOptions);

	<T extends Selectable<T>> List<T> selectMany(List<T> selectableOptions);

	<T extends Executable<T>> T executeOne(List<T> executableOptions);

	<T extends Executable<T>> List<T> executeMany(List<T> executablOptions);
}
