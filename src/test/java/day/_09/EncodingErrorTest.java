package day._09;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.LongCaster;

import java.util.List;

import static org.junit.Assert.*;

public class EncodingErrorTest {

    private EncodingError encodingError;
    private InputReader<Long> inputReader = new InputReader<>(new LongCaster());

    @Before
    public void setUp() {
        encodingError = new EncodingError();
    }

    @Test
    public void testP1WithTestInputs() {
        final List<Long> d9P1TestInputs = inputReader.readInputFile("d9/d9_p1_test_inputs");
        final long actual = encodingError.solve(d9P1TestInputs, 5);
        assertEquals(127, actual);
    }

    @Test
    public void testP1WithInputs() {
        final List<Long> d9P1TestInputs = inputReader.readInputFile("d9/d9_inputs");
        final long actual = encodingError.solve(d9P1TestInputs, 25);
        assertEquals(375054920L, actual);
    }

    @Test
    public void testP2WithTestInputs() {
        final List<Long> d9P1TestInputs = inputReader.readInputFile("d9/d9_p1_test_inputs");
        final long actual = encodingError.solve2(d9P1TestInputs, 127L);
        assertEquals(62, actual);
    }

    @Test
    public void testP2WithInputs() {
        final List<Long> d9P1TestInputs = inputReader.readInputFile("d9/d9_inputs");
        final long actual = encodingError.solve2(d9P1TestInputs, 375054920L);
        assertEquals(54142584L, actual);
    }
}