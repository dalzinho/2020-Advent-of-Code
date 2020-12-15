package day._15;

import java.util.*;
import java.util.stream.Collectors;

public class RambunctiousRecitation {

    long solveForInput(String input, int lastSpokenAtTurn) {

        final List<Long> startingNumbers = Arrays.stream(input.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Map<Long, Long> lastAppearanceOf = prepopulateAppearanceMap(startingNumbers);

        long lastSpoken = startingNumbers.get(startingNumbers.size() - 1);

        for (int i = startingNumbers.size(); i < lastSpokenAtTurn; i++) {
            if (lastAppearanceOf.containsKey(lastSpoken)) {
                long temp = lastSpoken;
                lastSpoken = i - lastAppearanceOf.get(lastSpoken);
                lastAppearanceOf.put(temp, (long) i);
            } else {
                lastAppearanceOf.put(lastSpoken, (long) i);
                lastSpoken = 0;
            }
        }

        return lastSpoken;
    }

    private Map<Long, Long> prepopulateAppearanceMap(List<Long> startingNumbers) {
        Map<Long, Long> lastAppearanceOf = new HashMap<>();

        for (int i = 0; i < startingNumbers.size() - 1; i++) {
            lastAppearanceOf.put(startingNumbers.get(i), (long) i + 1);
        }
        return lastAppearanceOf;
    }
}
