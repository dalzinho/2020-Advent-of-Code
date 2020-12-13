package day._13;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class ShuttleSearchTest {

    private static final InputReader<String> INPUT_READER = new InputReader<>(new StringCaster());

    private List<String> testInputs = INPUT_READER.readInputFile("_13/d13_test_inputs");
    private List<String> inputs = INPUT_READER.readInputFile("_13/d13_inputs");

    private ShuttleSearch shuttleSearch;

    @Before
    public void setUp() {
        shuttleSearch = new ShuttleSearch(new TimeTableInputParser());
    }

    @Test
    public void testPuzzle1() {
        final long solve = shuttleSearch.solution1(testInputs);
        assertEquals(295, solve);
    }

    @Test
    public void puzzle1() {
        final long solve = shuttleSearch.solution1(inputs);
        assertEquals(2092, solve);
    }

    @Test
    public void testPuzzle2() {
        final long solve = shuttleSearch.solution2(testInputs);
        assertEquals(1068781, solve);
    }

    @Test
    public void puzzle2() {
        final long solve = shuttleSearch.solution2(inputs);
        assertEquals(702970661767766L, solve);
    }
}