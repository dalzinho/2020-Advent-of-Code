package day._7;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandyHaversacksSolutionTest {

    private static final String TARGET_COLOUR = "shiny gold";


    private HandyHaversacksSolution countOptionsSolution;
    private HandyHaversacksSolution totalBagCountSolution;

    private InputReader<String> ir = new InputReader<>(new StringCaster());


    @Before
    public void setUp() {
        BagBuilder bagBuilder = new BagBuilder();
        countOptionsSolution = new CountOptionsSolution(bagBuilder, TARGET_COLOUR);
        totalBagCountSolution = new TotalBagCountSolution(bagBuilder, TARGET_COLOUR);
    }

    @Test
    public void test_WithTestInputs() {
        final List<String> d7TestInputs = ir.readInputFile("d7_p1_test_inputs");
        final long solve = countOptionsSolution.solve(d7TestInputs);
        assertEquals(4L, solve);
    }

    @Test
    public void name() {
        final List<String> d7Inputs = ir.readInputFile("d7_inputs");
        final long solve = countOptionsSolution.solve(d7Inputs);
        assertEquals(289, solve);
    }

    @Test
    public void test_solution2_testInputs() {
        final List<String> p2TestInputs = ir.readInputFile("d7_p2_test_inputs");
        final long shiny_gold = totalBagCountSolution.solve(p2TestInputs);
        assertEquals(126, shiny_gold);
    }

    @Test
    public void anothername() {
        final List<String> d7Inputs = ir.readInputFile("d7_inputs");
        final long sol = totalBagCountSolution.solve(d7Inputs);
        assertEquals(30055, sol);
    }
}