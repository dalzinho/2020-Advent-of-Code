package day._11.generator;

import java.util.ArrayList;
import java.util.List;

public class LineOfSightGenerator extends Generator {

    @Override
    public List<List<String>> generate(List<List<String>> previousGeneration) {
        this.previousGeneration = previousGeneration;

        List<List<String>> nextGeneration = new ArrayList<>();

        for (int y = 0; y < previousGeneration.size(); y++) {
            List<String> nextRow = new ArrayList<>();
            for (int x = 0; x < previousGeneration.get(y).size(); x++) {
                String seat = getNextSeat(x, y, 5);
                nextRow.add(seat);
            }
            nextGeneration.add(nextRow);
        }

        return nextGeneration;
    }

    protected long getNeighboursFor(int x, int y) {
        List<String> allVisibleSeats = new ArrayList<>();

        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, -1, 0));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, 1, 0));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, 0, -1));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, 0, 1));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, -1, -1));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, -1, 1));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, 1, -1));
        allVisibleSeats.add(nextSeatWithinLineOfSight(x, y, 1, 1));

        return allVisibleSeats.stream()
                .filter("#"::equals)
                .count();
    }

    private String nextSeatWithinLineOfSight(int x, int y, int xIncrement, int yIncrement) {
        String nextSeat;

        while (true) {
            x += xIncrement;
            y += yIncrement;

            nextSeat = seatAt(x, y);

            if (!".".equals(nextSeat)) {
                return nextSeat;
            }
        }
    }
}
