package day._5;

import day._5.util.BinarySearcher;
import day._5.util.SeatPatternDecoder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeatCalculatorTest {

    private SeatCalculator seatCalculator;

    @Before
    public void setUp() throws Exception {
        seatCalculator = new SeatCalculator(new SeatPatternDecoder(), new BinarySearcher());
    }

    @Test
    public void providedTestCase1() {
        final int actual = seatCalculator.getSeatFromDescription("BFFFBBFRRR");
        assertEquals(567, actual);
    }

    @Test
    public void providedTestCase2() {
        final int actual = seatCalculator.getSeatFromDescription("FFFBBBFRRR");
        assertEquals(119, actual);
    }

    @Test
    public void providedTestCase3() {
        final int actual = seatCalculator.getSeatFromDescription("BBFFBBFRLL");
        assertEquals(820, actual);
    }
}