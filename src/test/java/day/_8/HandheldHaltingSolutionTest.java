package day._8;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class HandheldHaltingSolutionTest {

    private InputReader<String> inputReader = new InputReader<>(new StringCaster());
    private HandheldHaltingSolution handheldHaltingSolution;

    @Before
    public void setUp() throws Exception {
        handheldHaltingSolution = new HandheldHaltingSolution();
    }

    @Test
    public void solution1_withTestInputs() {
        final List<String> d8_p1_test_inputs = inputReader.readInputFile("d8/d8_p1_test_inputs");
        final long solution = handheldHaltingSolution.solve(d8_p1_test_inputs);
        assertEquals(5, solution);
    }

    @Test
    public void solution1_withInputs() {
        final List<String> d8Inputs = inputReader.readInputFile("d8/d8_inputs");
        final long solution = handheldHaltingSolution.solve(d8Inputs);
        assertEquals(1446, solution);
    }

    @Test
    public void solution2_withTestInputs() {
        final List<String> d8_p1_test_inputs = inputReader.readInputFile("d8/d8_p1_test_inputs");
        final long solution = handheldHaltingSolution.solve2(d8_p1_test_inputs);
        assertEquals(8, solution);
    }

    @Test
    public void solution2_withInputs() {
        final List<String> d8Inputs = inputReader.readInputFile("d8/d8_inputs");
        final long solution = handheldHaltingSolution.solve2(d8Inputs);
        assertEquals(1403, solution);
    }
}