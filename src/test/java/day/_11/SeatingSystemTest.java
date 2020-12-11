package day._11;

import day._11.generator.AdjacentSeatGenerator;
import day._11.generator.LineOfSightGenerator;
import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeatingSystemTest {

    private SeatingSystem adjacentSeatSolution;
    private SeatingSystem lineOfSightSeatSolution;

    private InputReader<String> ir = new InputReader<>(new StringCaster());

    @Before
    public void setUp() {
        adjacentSeatSolution = new SeatingSystem(new AdjacentSeatGenerator());
        lineOfSightSeatSolution = new SeatingSystem(new LineOfSightGenerator());
    }

    @Test
    public void test_p1_testInputs() {
        final List<String> strings = ir.readInputFile("d11/d11_p1_test_inputs");
        final long solve = adjacentSeatSolution.solve(strings);
        assertEquals(37L, solve);
    }

    @Test
    public void test_p1_realInputs() {
        final List<String> strings = ir.readInputFile("d11/d11_inputs");
        final long solve = adjacentSeatSolution.solve(strings);
        assertEquals(2481, solve);
    }

    @Test
    public void test_p2_testInputs() {
        final List<String> strings = ir.readInputFile("d11/d11_p1_test_inputs");
        final long solve = lineOfSightSeatSolution.solve(strings);
        assertEquals(26L, solve);
    }

    @Test
    public void test_p2_realInputs() {
        final List<String> strings = ir.readInputFile("d11/d11_inputs");
        final long solve = lineOfSightSeatSolution.solve(strings);
        assertEquals(2227, solve);
    }
}