package day._5;

import day._5.solution.MaxSeatSolution;
import day._5.solution.MySeatSolution;
import day._5.util.BinarySearcher;
import day._5.util.SeatPatternDecoder;
import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryBoardingTest {

    private InputReader<String> inputReader;
    private BinaryBoarding binaryBoarding;
    private MaxSeatSolution maxSeatSolution;
    private MySeatSolution mySeatSolution;

    @Before
    public void setUp() {
        inputReader = new InputReader<>(new StringCaster());
        binaryBoarding = new BinaryBoarding();
        final SeatCalculator seatCalculator = new SeatCalculator(new SeatPatternDecoder(), new BinarySearcher());
        maxSeatSolution = new MaxSeatSolution(seatCalculator);
        mySeatSolution = new MySeatSolution(seatCalculator);
    }

    @Test
    public void solution_1_providedTestCases() {
        int maxSeatNumber = binaryBoarding.getSeatFromDescription(Arrays.asList("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"), maxSeatSolution);
        assertEquals(820, maxSeatNumber);
    }

    @Test
    public void solution1_inputs() {
        final List<String> d5Inputs = inputReader.readInputFile("d5_inputs");

        final int maxSeatNumber = binaryBoarding.getSeatFromDescription(d5Inputs, maxSeatSolution);
        assertEquals(880, maxSeatNumber);
    }

    @Test
    public void solution2_inputs() {
        final List<String> d5Inputs = inputReader.readInputFile("d5_inputs");

        final int mySeat = binaryBoarding.getSeatFromDescription(d5Inputs, mySeatSolution);
        assertEquals(731, mySeat);
    }


}
