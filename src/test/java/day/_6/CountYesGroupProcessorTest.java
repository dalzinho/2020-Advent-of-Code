package day._6;

import org.junit.Before;
import org.junit.Test;
import util.InputFlattener;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.*;

public class CountYesGroupProcessorTest {

    private CustomCustomsSolution customCustomsSolution;

    @Before
    public void setUp() throws Exception {
        customCustomsSolution = new CustomCustomsSolution(new InputFlattener(), new CountYesGroupProcessor());
    }

    @Test
    public void test() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d6Inputs = ir.readInputFile("d6_inputs");
        final long count = customCustomsSolution.solve(d6Inputs);
        assertEquals(6530L, count);
    }
}