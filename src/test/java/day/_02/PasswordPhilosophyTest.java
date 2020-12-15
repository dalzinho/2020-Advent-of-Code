package day._02;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.SolutionRunner;
import util.caster.StringCaster;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PasswordPhilosophyTest {

    private PasswordPhilosophy passwordPhilosophy;
    private CharacterCountValidator characterCountValidator;
    private BitwiseCharacterValidator bitwiseCharacterValidator;

    private String testInputOne;
    private String testInputTwo;
    private String testInputThree;

    @Before
    public void setup() {
        passwordPhilosophy = new PasswordPhilosophy();
        characterCountValidator = new CharacterCountValidator();
        bitwiseCharacterValidator = new BitwiseCharacterValidator();

        testInputOne = "1-3 a: abcde";
        testInputTwo = "1-3 b: cdefg";
        testInputThree = "2-9 c: ccccccccc";
    }

    @Test
    public void testCaseOne() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputOne), characterCountValidator);
        assertEquals(1, actual);
    }

    @Test
    public void testCaseTwo() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputTwo), characterCountValidator);
        assertEquals(0, actual);
    }

    @Test
    public void testCaseThree() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputThree), characterCountValidator);
        assertEquals(1, actual);
    }

    @Test
    public void testAllTestCases() {
        List<String> inputs = Arrays.asList(testInputOne, testInputTwo, testInputThree);
        long actual = passwordPhilosophy.countMatches(inputs, characterCountValidator);
        assertEquals(2, actual);
    }

    @Test
    public void testPartOneWithInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        List<String> d2PasswordInputs = ir.readInputFile("_02/d2_password_inputs");
        long process = passwordPhilosophy.countMatches(d2PasswordInputs, characterCountValidator);
        assertEquals(638, process);
    }

    @Test
    public void testDay2CaseOne() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputOne), bitwiseCharacterValidator);
        assertEquals(1, actual);
    }

    @Test
    public void testDay2CaseTwo() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputTwo), bitwiseCharacterValidator);
        assertEquals(0, actual);
    }

    @Test
    public void testDay2CaseThree() {
        long actual = passwordPhilosophy.countMatches(Collections.singletonList(testInputThree), bitwiseCharacterValidator);
        assertEquals(0, actual);
    }

    @Test
    public void testPartTwoWithInputs() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        List<String> d2PasswordInputs = ir.readInputFile("_02/d2_password_inputs");
        long process = passwordPhilosophy.countMatches(d2PasswordInputs, bitwiseCharacterValidator);
        assertEquals(699, process);
    }

    @Test
    public void testWithSolutionRunner() {
        InputReader<String> ir = new InputReader<>(new StringCaster());
        List<String> d2PasswordInputs = ir.readInputFile("_02/d2_password_inputs");

        SolutionRunner<String, Long> solutionRunner = new SolutionRunner<>();
        final Long solution1 = solutionRunner.solve(d2PasswordInputs, new PasswordPhilosophy(characterCountValidator));
        final Long solution2 = solutionRunner.solve(d2PasswordInputs, new PasswordPhilosophy(bitwiseCharacterValidator));

        assertEquals(638, (long) solution1);
        assertEquals(699, (long) solution2);
    }

}