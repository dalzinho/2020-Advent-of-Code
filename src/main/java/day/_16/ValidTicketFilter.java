package day._16;

import java.util.*;
import java.util.stream.Collectors;

public class ValidTicketFilter {

    public List<List<Long>> filterValid(PuzzleInputModel puzzleInputModel) {
        Set<Long> validNumbers = deriveAllValidNumbers(puzzleInputModel.getFieldWithBounds());

        return puzzleInputModel.getNearbyTickets()
                .stream()
                .filter(ticket -> ticketIsValid(ticket, validNumbers))
                .collect(Collectors.toList());
    }

    private boolean ticketIsValid(List<Long> ticket, Set<Long> validNumbers) {
        for (long i : ticket) {
            if (!validNumbers.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Long> filterInvalidValues(PuzzleInputModel puzzleInputModel) {
        Set<Long> validNumbers = deriveAllValidNumbers(puzzleInputModel.getFieldWithBounds());


        List<Long> invalidValues = new ArrayList<>();

        for (List<Long> ticket : puzzleInputModel.getNearbyTickets()) {
            for (long i : ticket) {
                if (!validNumbers.contains(i)) {
                    invalidValues.add(i);
                    break;
                }
            }
        }
        return invalidValues;
    }

    private Set<Long> deriveAllValidNumbers(Map<String, List<TicketValueBounds>> validNumbers) {
        return validNumbers.values()
                .stream()
                .flatMap(Collection::stream)
                .map(TicketValueBounds::range)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
