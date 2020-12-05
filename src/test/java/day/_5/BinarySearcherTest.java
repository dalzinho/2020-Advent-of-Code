package day._5;

import day._5.util.BinarySearcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class BinarySearcherTest {

    BinarySearcher binarySearcher;

    @Before
    public void setup() {
        binarySearcher = new BinarySearcher();
    }

    @Test
    public void testFindLowerOf2() {
        final int i = binarySearcher.find(1, Collections.singletonList(false));
        assertEquals(0, i);
    }

    @Test
    public void testFindGreaterOf2() {
        final int i = binarySearcher.find(1, Collections.singletonList(true));
        assertEquals(1, i);
    }

    @Test
    public void getZeroFromThree() {
        final int i = binarySearcher.find(3, Arrays.asList(false, false));
        assertEquals(0, i);
    }

    @Test
    public void getOneFromThree() {
        final int i = binarySearcher.find(2, Arrays.asList(false, true));
        assertEquals(1, i);
    }

    @Test
    public void getTwoFrom3() {
        final int i = binarySearcher.find(2, Arrays.asList(true, true));
        assertEquals(2, i);
    }

    @Test
    public void sampleInputFBFBBFFRLR() {
        final int i = binarySearcher.find(127, Arrays.asList(false, true, false, true, true, false, false));
        assertEquals(44, i);

    }

    @Test
    public void sampleInputBFFFBBFRRR() {
        final int row = binarySearcher.find(127, Arrays.asList(true, false, false, false, true, true, false));
        assertEquals(70, row);

        final int column = binarySearcher.find(7, Arrays.asList(true, true, true));
        assertEquals(7, column);
    }

    @Test
    public void sampleInputFFFBBBFRRR() {
        final int row = binarySearcher.find(127, Arrays.asList(false, false, false, true, true, true, false));
        assertEquals(14, row);

        final int column = binarySearcher.find(7, Arrays.asList(true, true, true));
        assertEquals(7, column);
    }

    @Test
    public void sampleInputBBFFBBFRLL() {
        final int row = binarySearcher.find(127, Arrays.asList(true, true, false, false, true, true, false));
        assertEquals(102, row);

        final int column = binarySearcher.find(7, Arrays.asList(true, false, false));
        assertEquals(4, column);
    }
}