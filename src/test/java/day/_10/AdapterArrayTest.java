package day._10;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.LongCaster;

import java.util.List;

import static org.junit.Assert.*;

public class AdapterArrayTest {

    private AdapterArray adapterArray;
    private final InputReader<Long> inputReader = new InputReader<>(new LongCaster());

    @Before
    public void setUp() {
        adapterArray = new AdapterArray();
    }

    @Test
    public void puzzle1_withTestInputs1() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_p1_test_inputs_1");
        long solution = adapterArray.solve(longs);
        assertEquals(7 * 5, solution);
    }

    @Test
    public void puzzle1_withTestInputs2() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_p1_test_inputs_2");
        long solution = adapterArray.solve(longs);
        assertEquals(22 * 10, solution);
    }

    @Test
    public void puzzle1_withInputs() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_inputs");
        long solution = adapterArray.solve(longs);
        assertEquals(1998, solution);
    }

    @Test
    public void puzzle2_withTestInputs1() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_p1_test_inputs_1");
        long solution = adapterArray.solve2(longs);
        assertEquals(8, solution);
    }

    @Test
    public void puzzle2_withTestInputs2() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_p1_test_inputs_2");
        long solution = adapterArray.solve2(longs);
        assertEquals(19208, solution);
    }

    @Test
    public void puzzle2_withInputs() {
        final List<Long> longs = inputReader.readInputFile("_10/d10_inputs");
        long solution = adapterArray.solve2(longs);
        assertEquals(347250213298688L, solution);
    }
}