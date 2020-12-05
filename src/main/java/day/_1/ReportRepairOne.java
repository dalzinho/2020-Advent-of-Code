package day._1;

import java.util.*;

public class ReportRepairOne {

    public long findProductOfMatchesToDepth(Long target, List<Long> inputs, int digitsRequired) {
        return findMatches(target, inputs)
                .getOrDefault(digitsRequired, new ArrayList<>())
                .stream()
                .reduce((a, b) -> a * b)
                .orElse(0L);
    }

    private Map<Integer, List<Long>> findMatches(Long target, final List<Long> inputs) {
        Map<Integer, List<Long>> results = new HashMap<>();

        for (long input : inputs) {
            long next = target - input;
            if (inputs.contains(next)) {
                results.put(2, Arrays.asList(input, next));
                break;
            }
        }

        for (long input : inputs) {
            long next = target - input;
            for (long nextInput : inputs) {
                if (nextInput == input) {
                    continue;
                }

                long nextAgain = next - nextInput;
                if (inputs.contains(nextAgain)) {
                    results.put(3, Arrays.asList(input, nextInput, nextAgain));
                }
            }
        }

        return results;
    }
}
