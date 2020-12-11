package day._05.util;

public class BinarySeatCalculator implements SeatCalculator{
    @Override
    public int getSeatFromDescription(String input) {
        final String zeroesReplaced = input.replaceAll("[FL]", "0");
        final String binaryString = zeroesReplaced.replaceAll("[BR]", "1");
        return Integer.parseInt(binaryString, 2);
    }
}
