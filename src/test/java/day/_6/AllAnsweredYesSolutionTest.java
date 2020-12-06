package day._6;

import org.junit.Before;
import org.junit.Test;
import util.InputFlattener;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class AllAnsweredYesSolutionTest {

    private CustomCustomsSolution allAnsweredYesSolution;

    @Before
    public void setUp() {
        allAnsweredYesSolution = new CustomCustomsSolution(new InputFlattener(), new AllAnsweredYesGroupProcessor());
    }

    @Test
    public void test() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d6Inputs = ir.readInputFile("d6_inputs");
        final Long solve = allAnsweredYesSolution.solve(d6Inputs);
        System.out.println(solve);
        assertTrue(solve > 479);
    }
}