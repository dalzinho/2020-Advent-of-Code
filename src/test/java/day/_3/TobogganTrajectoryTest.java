package day._3;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TobogganTrajectoryTest {

    private TobogganTrajectory tobogganTrajectory;
    private InputReader<String> inputReader;

    @Before
    public void setup() {
        tobogganTrajectory = new TobogganTrajectory();
        inputReader = new InputReader<>(new StringCaster());
    }

    @Test
    public void test() {
        List<List<Integer>> slopes = Collections.singletonList(Arrays.asList(3, 1));
        long treeCount = tobogganTrajectory.process(Arrays.asList("..##.......","#...#...#.."), slopes);
        assertEquals(0, treeCount);
    }

    @Test
    public void testWithInputs() {
        List<List<Integer>> slopes = Collections.singletonList(Arrays.asList(3, 1));

        final List<String> d3Inputs = inputReader.readInputFile("d3_inputs");
        final long treeCount = tobogganTrajectory.process(d3Inputs, slopes);
        assertEquals(289, treeCount);
    }

    @Test
    public void testPuzzleTwoWithTestInputsCase1_1() {
        puzzleTwoTestCase(Arrays.asList(1,1), 2);
    }

    @Test
    public void testPuzzleTwoWithTestInputsCase3_1() {
        puzzleTwoTestCase(Arrays.asList(3,1), 7);
    }

    @Test
    public void testPuzzleTwoWithTestInputsCase5_1() {
        puzzleTwoTestCase(Arrays.asList(5,1), 3);
    }

    @Test
    public void testPuzzleTwoWithTestInputsCas7_1() {
        puzzleTwoTestCase(Arrays.asList(7,1), 4);
    }

    @Test
    public void testPuzzleTwoWithTestInputsCas1_2() {
        puzzleTwoTestCase(Arrays.asList(1,2), 2);
    }

    private void puzzleTwoTestCase(List<Integer> slope, long expected) {
        final List<String> d3TestInputs = inputReader.readInputFile("d3_test_inputs");
        List<List<Integer>> slopes = Collections.singletonList(slope);
        final long actual = tobogganTrajectory.process(d3TestInputs, slopes);
        assertEquals(expected, actual);
    }

    @Test
    public void testPuzzleTwoWithTestInputs_productOfAllCases() {
        List<List<Integer>> slopes = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(3, 1),
                Arrays.asList(5, 1),
                Arrays.asList(7, 1),
                Arrays.asList(1, 2)
        );

        final List<String> d3TestInputs = inputReader.readInputFile("d3_test_inputs");
        final long actual = tobogganTrajectory.process(d3TestInputs, slopes);
        assertEquals(336, actual);
    }

    @Test
    public void testWithPuzzleTwo() {
        List<List<Integer>> slopes = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(3, 1),
                Arrays.asList(5, 1),
                Arrays.asList(7, 1),
                Arrays.asList(1, 2)
        );

        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d3Inputs = ir.readInputFile("d3_inputs");
        final long treeCount = tobogganTrajectory.process(d3Inputs, slopes);
        assertEquals(5_522_401_584L, treeCount);
    }
}
