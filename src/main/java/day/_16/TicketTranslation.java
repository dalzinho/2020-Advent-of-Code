package day._16;

import java.util.List;
import java.util.Map;

public class TicketTranslation {

    private final ValidTicketFilter validTicketFilter;
    private TicketFieldProcessor ticketFieldProcessor;

    public TicketTranslation(ValidTicketFilter validTicketFilter, TicketFieldProcessor ticketFieldProcessor) {
        this.validTicketFilter = validTicketFilter;
        this.ticketFieldProcessor = ticketFieldProcessor;
    }

    public long translate(PuzzleInputModel puzzleInputModel) {
        final List<Long> invalidValues = validTicketFilter.filterInvalidValues(puzzleInputModel);
        return invalidValues.stream().mapToLong(Long::longValue).sum();
    }

    public long workOutFields(PuzzleInputModel puzzleInputModel) {
        final Map<String, Long> myTicket = ticketFieldProcessor.process(puzzleInputModel, validTicketFilter);

        return myTicket.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("departure"))
                .map(Map.Entry::getValue)
                .reduce((a, b) -> a * b)
                .get();
    }
}
