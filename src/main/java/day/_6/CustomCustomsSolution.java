package day._6;

import util.InputFlattener;
import util.Solution;

import java.util.List;

public class CustomCustomsSolution implements Solution<String, Long> {

    private final InputFlattener inputFlattener;
    private final GroupProcessor groupProcessor;

    public CustomCustomsSolution(InputFlattener inputFlattener, GroupProcessor groupProcessor) {
        this.inputFlattener = inputFlattener;
        this.groupProcessor = groupProcessor;
    }

    @Override
    public Long solve(List<String> input) {
        return inputFlattener.flatten(input, "\n")
                .stream()
                .map(groupProcessor::process)
                .mapToLong(Long::longValue)
                .sum();
    }
}
