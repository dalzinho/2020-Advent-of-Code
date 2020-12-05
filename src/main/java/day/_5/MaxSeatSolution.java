package day._5;

import day._5.util.SeatCalculator;
import util.Solution;

import java.util.List;

public class MaxSeatSolution implements Solution<String, Integer> {

    private final SeatCalculator seatCalculator;

    public MaxSeatSolution(SeatCalculator seatCalculator) {
        this.seatCalculator = seatCalculator;
    }

    @Override
    public Integer solve(List<String> input) {
        return input.stream()
                .map(seatCalculator::getSeatFromDescription)
                .mapToInt(Integer::intValue)
                .max().orElse(Integer.MIN_VALUE);
    }
}
