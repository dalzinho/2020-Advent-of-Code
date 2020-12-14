package day._14;

import day._14.input.InputTranslator;
import day._14.transformer.KeyMaskingTransformer;
import day._14.transformer.ValueMaskingTransformer;
import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class DockingDataTest {

    protected static final InputReader<String> INPUT_READER = new InputReader<>(new StringCaster());

    protected List<String> testInputs = INPUT_READER.readInputFile("_14/d14_test_inputs");
    protected List<String> testInputs_2 = INPUT_READER.readInputFile("_14/d14_p2_test_inputs");
    protected List<String> inputs = INPUT_READER.readInputFile("_14/d14_inputs");

    private DockingData solution1;
    private DockingData solution2;

    @Before
    public void setup() {
        solution1 = new DockingData(new InputTranslator(), new ValueMaskingTransformer());
        solution2 = new DockingData(new InputTranslator(), new KeyMaskingTransformer());
    }

    @Test
    public void puzzle1_test() {
        long solution = solution1.solve(testInputs);
        assertEquals(165, solution);
    }

    @Test
    public void puzzle1() {
        long solution = solution1.solve(inputs);
        assertEquals(18630548206046L, solution);
    }

    @Test
    public void name() {
        final long solve = solution2.solve(testInputs_2);
        assertEquals(208, solve);
    }

    @Test
    public void test2() {
        final long solve = solution2.solve(inputs);
        assertEquals(4254673508445L, solve);
    }
}