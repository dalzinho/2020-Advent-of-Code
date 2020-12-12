package day._12;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class RainRiskTest {

    private InputReader ir = new InputReader<>(new StringCaster());
    private List<String> testInputs = ir.readInputFile("_12/d12_test_inputs");
    private List<String> inputs = ir.readInputFile("_12/d12_inputs");

    private RainRisk rainRisk;

    @Before
    public void setUp() throws Exception {
        rainRisk = new RainRisk();
    }

    @Test
    public void part1_testInputs() {
        final long solution = rainRisk.solve(testInputs);
        assertEquals(25, solution);
    }

    @Test
    public void part1_inputs() {
        final long solution = rainRisk.solve(inputs);
        assertEquals(1687, solution);
    }

    @Test
    public void part2_testInputs() {
        final long solution = rainRisk.solve2(testInputs);
        assertEquals(286, solution);
    }

    @Test
    public void part2_inputs() {
        final long solution = rainRisk.solve2(inputs);
        assertEquals(20873, solution);
    }
}