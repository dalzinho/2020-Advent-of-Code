package day._05;

import day._05.util.BinarySeatCalculator;
import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.SolutionRunner;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryBoardingTest {

    private InputReader<String> inputReader;
    private SolutionRunner<String, Integer> solutionRunner;
    private MaxSeatSolution maxSeatSolution;
    private MySeatSolution mySeatSolution;

    @Before
    public void setUp() {
        inputReader = new InputReader<>(new StringCaster());
        solutionRunner = new SolutionRunner<>();
        maxSeatSolution = new MaxSeatSolution(new BinarySeatCalculator());
        mySeatSolution = new MySeatSolution(new BinarySeatCalculator());
    }

    @Test
    public void solution_1_providedTestCases() {
        int maxSeatNumber = solutionRunner.solve(Arrays.asList("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"), maxSeatSolution);
        assertEquals(820, maxSeatNumber);
    }

    @Test
    public void solution1_inputs() {
        final List<String> d5Inputs = inputReader.readInputFile("_05/d5_inputs");

        final int maxSeatNumber = solutionRunner.solve(d5Inputs, maxSeatSolution);
        assertEquals(880, maxSeatNumber);
    }

    @Test
    public void solution2_inputs() {
        final List<String> d5Inputs = inputReader.readInputFile("_05/d5_inputs");

        final int mySeat = solutionRunner.solve(d5Inputs, mySeatSolution);
        assertEquals(731, mySeat);
    }


}
