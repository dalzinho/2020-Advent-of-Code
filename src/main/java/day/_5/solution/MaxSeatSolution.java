package day._5.solution;

import day._5.SeatCalculator;

import java.util.List;

public class MaxSeatSolution implements Solution {

    private final SeatCalculator seatCalculator;

    public MaxSeatSolution(SeatCalculator seatCalculator) {
        this.seatCalculator = seatCalculator;
    }

    @Override
    public int solve(List<String> input) {
        return input.stream()
                .map(seatCalculator::getSeatFromDescription)
                .mapToInt(Integer::intValue)
                .max().orElse(Integer.MIN_VALUE);
    }
}
