package day._4;

import day._4.validator.FieldPresentPassportValidator;
import day._4.validator.FieldsCheckedPassportValidator;
import day._4.validator.PassportValidator;
import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PassportProcessingTest {

    private PassportProcessing passportProcessing;
    private PassportValidator fieldPresentValidator;
    private PassportValidator fieldsCheckedValidator;

    @Before
    public void setup() {
        passportProcessing = new PassportProcessing(new PassportInputFlattener(), new PassportInputMapper());
        fieldPresentValidator = new FieldPresentPassportValidator();
        fieldsCheckedValidator = new FieldsCheckedPassportValidator();
    }

    @Test
    public void testInputOne() {
        final List<String> input = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd", "byr:1937 iyr:2017 cid:147 hgt:183cm");

        final long actual = passportProcessing.validate(input, fieldPresentValidator);
        assertEquals(1, actual);
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

        final long actual = passportProcessing.validate(inputs, fieldPresentValidator);
        assertEquals(1, actual);
    }

    @Test
    public void testWithTestInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d4_test_input = ir.readInputFile("d4_test_inputs");
        final long actual = passportProcessing.validate(d4_test_input, fieldPresentValidator);
        assertEquals(2, actual);
    }

    @Test
    public void testWithActualInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d4_test_input = ir.readInputFile("d4_inputs");
        final long actual = passportProcessing.validate(d4_test_input, fieldPresentValidator);
        assertEquals(192, actual);
    }

    @Test
    public void p2_testOneKnownValidInput() {
        List<String> inputs = Arrays.asList(
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
                "hcl:#623a2f"
        );

        final long actual = passportProcessing.validate(inputs, fieldsCheckedValidator);
        assertEquals(1, actual);
    }

    @Test
    public void testWithActualInputsPuzzleTwo() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        final List<String> d4_test_input = ir.readInputFile("d4_inputs");
        final long actual = passportProcessing.validate(d4_test_input, fieldsCheckedValidator);
        assertEquals(101, actual);
    }


}