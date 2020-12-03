package day2;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.StringCaster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PasswordPhilosophyTest {

    private PasswordPhilosophy passwordPhilosophy;

    private String testInputOne;
    private String testInputTwo;
    private String testInputThree;

    @Before
    public void setup() {
        passwordPhilosophy = new PasswordPhilosophy();

        testInputOne = "1-3 a: abcde";
        testInputTwo = "1-3 b: cdefg";
        testInputThree = "2-9 c: ccccccccc";
    }

    @Test
    public void testCaseOne() {
        long actual = passwordPhilosophy.processRuleSetOne(Collections.singletonList(testInputOne));
        assertEquals(1, actual);
    }

    @Test
    public void testCaseTwo() {
        long actual = passwordPhilosophy.processRuleSetOne(Collections.singletonList(testInputTwo));
        assertEquals(0, actual);
    }

    @Test
    public void testCaseThree() {
        long actual = passwordPhilosophy.processRuleSetOne(Collections.singletonList(testInputThree));
        assertEquals(1, actual);
    }

    @Test
    public void testAllTestCases() {
        List<String> inputs = Arrays.asList(testInputOne, testInputTwo, testInputThree);
        long actual = passwordPhilosophy.processRuleSetOne(inputs);
        assertEquals(2, actual);
    }

    @Test
    public void testPartOneWithInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        List<String> d2PasswordInputs = ir.readInputFile("d2_password_inputs");
        long process = passwordPhilosophy.processRuleSetOne(d2PasswordInputs);
        assertEquals(638, process);
    }

    @Test
    public void testDay2CaseOne() {
        long actual = passwordPhilosophy.processRuleSetTwo(Collections.singletonList(testInputOne));
        assertEquals(1, actual);
    }

    @Test
    public void testDay2CaseTwo() {
        long actual = passwordPhilosophy.processRuleSetTwo(Collections.singletonList(testInputTwo));
        assertEquals(0, actual);
    }

    @Test
    public void testDay2CaseThree() {
        long actual = passwordPhilosophy.processRuleSetTwo(Collections.singletonList(testInputThree));
        assertEquals(0, actual);
    }

    @Test
    public void testPartTwoWithInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        List<String> d2PasswordInputs = ir.readInputFile("d2_password_inputs");
        long process = passwordPhilosophy.processRuleSetTwo(d2PasswordInputs);
        assertEquals(699, process);
    }


}