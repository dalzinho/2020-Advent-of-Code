package util;

import java.util.List;

public class SolutionRunner<T, R> {

    public R solve(List<T> inputs, Solution<T, R> solution) {
        return solution.solve(inputs);
    }
}
