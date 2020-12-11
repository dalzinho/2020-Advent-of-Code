package day._11.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountOccupiedOnlyAdjacentSeatGenerator extends Generator {

    @Override
    public List<List<String>> generate(List<List<String>> previousGeneration) {
        this.previousGeneration = previousGeneration;

        List<List<String>> nextGeneration = new ArrayList<>();
        for (int y = 0; y < previousGeneration.size(); y++) {
            List<String> nextRow = new ArrayList<>();
            for (int x = 0; x < previousGeneration.get(y).size(); x++) {
                String seat = getNextSeat(x, y, 4);
                nextRow.add(seat);
            }
            nextGeneration.add(nextRow);
        }
        return nextGeneration;
    }

    protected long getNeighboursFor(int x, int y) {
        String aboveLeft = seatAt(x - 1, y - 1);
        String above = seatAt(x, y - 1);
        String aboveRight = seatAt(x + 1, y - 1);
        String left = seatAt(x - 1, y);
        String right = seatAt(x + 1, y);
        String belowLeft = seatAt(x - 1, y + 1);
        String below = seatAt(x, y + 1);
        String belowRight = seatAt(x + 1, y + 1);

        return Stream.of(aboveLeft, above, aboveRight, left, right, belowLeft, below, belowRight)
                .filter("#"::equals)
                .count();
    }


}
