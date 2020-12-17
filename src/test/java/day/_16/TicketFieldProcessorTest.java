package day._16;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TicketFieldProcessorTest extends TicketTranslationTest {

    private TicketFieldProcessor ticketFieldProcessor;

    @Before
    public void setUp() {
        ticketFieldProcessor = new TicketFieldProcessor();
    }

    @Test
    public void runWithTestInputs() {
        Map<String, Long> ticket = ticketFieldProcessor.process(testInputs2, new ValidTicketFilter());
        assertEquals(12, (long) ticket.get("class"));
        assertEquals(11, (long) ticket.get("row"));
        assertEquals(13, (long) ticket.get("seat"));
    }
}