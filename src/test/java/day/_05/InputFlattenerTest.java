package day._05;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.InputFlattener;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class InputFlattenerTest {

    private InputFlattener inputFlattener;

    @Before
    public void setUp() throws Exception {
        inputFlattener = new InputFlattener();
    }

    @Test
    public void testCaseOne() {
        final List<String> inputs = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd", "byr:1937 iyr:2017 cid:147 hgt:183cm");
        final List<List<String>> flatten = inputFlattener.flatten(inputs, " ");
        assertEquals(1, flatten.size());

        List<String> flatInputs = flatten.get(0);
        assertEquals(8, flatInputs.size());
    }

    @Test
    public void testMultiple() {
        final List<String> inputs = Arrays.asList(
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929"
        );
        final List<List<String>> flatten = inputFlattener.flatten(inputs, " ");
        assertEquals(2, flatten.size());

        List<String> flatInputs = flatten.get(0);
        assertEquals(8, flatInputs.size());

        List<String> secondInputs = flatten.get(1);
        assertEquals(7, secondInputs.size());
    }

    @Test
    public void testWithTestInputs() {
        InputReader<String> ir =  new InputReader<>(new StringCaster());
        final List<String> d4_test_input = ir.readInputFile("d4_test_inputs");
        final List<List<String>> flatten = inputFlattener.flatten(d4_test_input, " ");
        assertEquals(4, flatten.size());
    }
}