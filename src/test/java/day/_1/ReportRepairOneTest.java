package day_1;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.LongCaster;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportRepairOneTest {

    private ReportRepairOne reportRepairOne;

    @Before
    public void setup() {
        reportRepairOne = new ReportRepairOne();
    }

    @Test
    public void matchesEntriesSumming2020() {
        List<Long> integers = Arrays.asList(2019L, 100L, 1L);
        long actual = reportRepairOne.findProductOfMatchesToDepth(2020L, integers, 2);
        assertEquals(2019, actual);
    }

    @Test
    public void matchesEntriesSumming2020_andMultiplies() {
        List<Long> integers = Arrays.asList(2018L, 100L, 2L);
        long actual = reportRepairOne.findProductOfMatchesToDepth(2020L, integers, 2);
        assertEquals(4036, actual);
    }

    @Test
    public void runWithInputs_2case() {
        InputReader<Long> ir = new InputReader<>(new LongCaster());
        List<Long> d1_inputs = ir.readInputFile("d1_inputs");
        long execute = reportRepairOne.findProductOfMatchesToDepth(2020L, d1_inputs, 2);
        assertEquals(987339, execute);
    }

    @Test
    public void matchesEntriesSumming2020_threeCase() {
        long productOfMatchesToDepth = reportRepairOne.findProductOfMatchesToDepth(2020L, Arrays.asList(2017L, 2L, 1L), 3);
        assertEquals(2017 * 2, productOfMatchesToDepth);
    }

    @Test
    public void runWithInputs_3case() {
        InputReader<Long> ir = new InputReader<>(new LongCaster());
        List<Long> d1_inputs = ir.readInputFile("d1_inputs");
        long execute = reportRepairOne.findProductOfMatchesToDepth(2020L, d1_inputs, 3);
        assertEquals(259521570, execute);
    }
}