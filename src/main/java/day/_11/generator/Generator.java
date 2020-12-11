package day._11.generator;

import java.util.List;

public abstract class Generator {

    protected List<List<String>> previousGeneration;

    public abstract List<List<String>> generate(List<List<String>> previousGeneration);

    protected String seatAt(int x, int y) {
        String s;
        try {
            s = previousGeneration.get(y).get(x);
        } catch (Exception e) {
            return null;
        }
        return s;
    }

    protected String getNextSeat(int x, int y, int numberOfOccupiedToEmptySeat) {
        String seat = seatAt(x, y);

        if (!".".equals(seat)) {
            seat = flipSeat(x, y, numberOfOccupiedToEmptySeat, seat);
        }

        return seat;
    }

    private String flipSeat(int x, int y, int numberOfOccupiedToEmptySeat, String seat) {
        final long countOfOccupiedNeighbours = getNeighboursFor(x, y);
        if ("#".equals(seat)) {
            seat = countOfOccupiedNeighbours >= numberOfOccupiedToEmptySeat ? "L" : seat;
        } else if ("L".equals(seat) && countOfOccupiedNeighbours == 0) {
            seat = "#";
        }
        return seat;
    }

    protected abstract long getNeighboursFor(int x, int y);
}
