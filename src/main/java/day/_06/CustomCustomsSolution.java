package day._06;

import util.ResultProcessor;
import util.InputFlattener;
import util.Solution;

import java.util.List;

public class CustomCustomsSolution implements Solution<String, Long> {

    private final InputFlattener inputFlattener;
    private final ResultProcessor<String, Long> resultProcessor;

    public CustomCustomsSolution(InputFlattener inputFlattener, ResultProcessor<String, Long> resultProcessor) {
        this.inputFlattener = inputFlattener;
        this.resultProcessor = resultProcessor;
    }

    @Override
    public Long solve(List<String> input) {
        return inputFlattener.flatten(input, "\n")
                .stream()
                .map(resultProcessor::process)
                .mapToLong(Long::longValue)
                .sum();
    }
}
