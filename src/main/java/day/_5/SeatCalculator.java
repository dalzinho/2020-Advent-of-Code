package day._5;

import day._5.util.BinarySearcher;
import day._5.util.SeatPatternDecoder;

import java.util.List;
import java.util.Map;

import static day._5.util.SeatPatternDecoder.COLUMN;
import static day._5.util.SeatPatternDecoder.ROW;

public class SeatCalculator {

    private final SeatPatternDecoder seatPatternDecoder;
    private final BinarySearcher binarySearcher;

    public SeatCalculator(SeatPatternDecoder seatPatternDecoder, BinarySearcher binarySearcher) {
        this.seatPatternDecoder = seatPatternDecoder;
        this.binarySearcher = binarySearcher;
    }

    public int getSeatFromDescription(String input) {
        final Map<String, List<Boolean>> booleanMap = seatPatternDecoder.decodeInput(input);

        int column = binarySearcher.find(127, booleanMap.get(ROW));
        int row = binarySearcher.find(7, booleanMap.get(COLUMN));

        return (column * 8) + row;
    }
}
