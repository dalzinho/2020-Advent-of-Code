package util;

import java.util.List;

public interface Solution<T, R> {

    R solve(List<T> input);

}
