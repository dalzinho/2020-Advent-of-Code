package day._9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EncodingError {

    public long solve(List<Long> inputs, int preamble) {
        Set<Long> validNumbers = calculateValidNumbers(inputs.subList(0, preamble));

        for (int i = preamble; i < inputs.size(); i++) {
            if (!validNumbers.contains(inputs.get(i))) {
                return inputs.get(i);
            }

            validNumbers = calculateValidNumbers(inputs.subList(i - preamble + 1, i + 1));
        }

        return 0L;
    }

    private Set<Long> calculateValidNumbers(List<Long> subList) {
        Set<Long> valid = new HashSet<>();

        for (int i = 0; i < subList.size(); i++) {
            for (int j = i + 1; j < subList.size(); j++) {
                valid.add(subList.get(i) + subList.get(j));
            }
        }

        return valid;
    }

    public long solve2(List<Long> inputs, long target) {
        for (int i = 0; i < inputs.size(); i++) {
            long sum = inputs.get(i);
            List<Long> contiguousDigits = new ArrayList<>();
            contiguousDigits.add(inputs.get(i));

            for (int j = i + 1; j < inputs.size(); j++) {
                sum += inputs.get(j);
                contiguousDigits.add(inputs.get(j));
                if (sum == target) {
                    final List<Long> sorted = contiguousDigits.stream().sorted().collect(Collectors.toList());
                    return sorted.get(0) + sorted.get(sorted.size() - 1);
                } else if (sum > target) {
                    break;
                }
            }
        }
        return 0L;
    }

}
