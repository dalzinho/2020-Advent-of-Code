package day._15;

import org.junit.Test;

import static org.junit.Assert.*;

public class RambunctiousRecitationTest {

    RambunctiousRecitation rambunctiousRecitation = new RambunctiousRecitation();

    private static final String THE_ATCHO_INPUT = "13,0,10,12,1,5,8";

    @Test
    public void name() {
        String input = "0,3,6";
        final long lastSpoken = rambunctiousRecitation.solveForInput(input, 10);
        assertEquals(0, lastSpoken);
    }

    @Test
    public void zero_three_six_x_2020() {
        String input = "0,3,6";
        final long lastSpoken = rambunctiousRecitation.solveForInput(input, 2020);
        assertEquals(436, lastSpoken);
    }

    @Test
    public void solution1() {
        final long lastSpoken = rambunctiousRecitation.solveForInput(THE_ATCHO_INPUT, 2020);
        assertEquals(260, lastSpoken);
    }

    @Test
    public void solution2() {
        final long lastSpoken = rambunctiousRecitation.solveForInput(THE_ATCHO_INPUT, 30_000_000);
        assertEquals(950, lastSpoken);
    }
}