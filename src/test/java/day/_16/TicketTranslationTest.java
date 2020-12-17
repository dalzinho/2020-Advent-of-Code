package day._16;

import org.junit.Before;
import org.junit.Test;
import util.InputReader;
import util.caster.StringCaster;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicketTranslationTest {

    InputReader<String> ir = new InputReader<>(new StringCaster());
    InputParser inputParser = new InputParser();

    private final PuzzleInputModel testInputs = preprocessInputs("_16/d16_test_inputs");
    protected final PuzzleInputModel testInputs2 = preprocessInputs("_16/d16_test_inputs_2");
    private final PuzzleInputModel inputs = preprocessInputs("_16/d16_inputs");

    private TicketTranslation ticketTranslation;

    @Before
    public void setUp() {
        ticketTranslation = new TicketTranslation(new ValidTicketFilter(), new TicketFieldProcessor());

    }

    private PuzzleInputModel preprocessInputs(String filePath) {
        final List<String> strings = ir.readInputFile(filePath);
        return inputParser.parse(strings);
    }

    @Test
    public void puzzle1TestInputs() {
        final long translate = ticketTranslation.translate(testInputs);
        assertEquals(71, translate);
    }

    @Test
    public void puzzle1RealInputs() {
        final long translate = ticketTranslation.translate(inputs);
        assertEquals(23122, translate);
    }

    @Test
    public void puzzle2TestInputs() {
        final long translate = ticketTranslation.workOutFields(inputs);
        assertEquals(71, translate);
    }
}