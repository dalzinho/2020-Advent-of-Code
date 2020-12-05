package day._5.solution;

import day._5.SeatCalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MySeatSolution implements Solution {

    private final SeatCalculator seatCalculator;

    public MySeatSolution(SeatCalculator seatCalculator) {
        this.seatCalculator = seatCalculator;
    }

    @Override
    public int solve(List<String> input) {
        final List<Integer> sortedList = input.stream()
                .mapToInt(seatCalculator::getSeatFromDescription)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int min = sortedList.get(0);
        int max = sortedList.get(sortedList.size() - 1);

        return IntStream.range(min, max)
                .filter(i -> !sortedList.contains(i))
                .boxed()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("couldn't find a seat with given inputs"));
    }
}
