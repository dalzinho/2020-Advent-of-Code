package day._16;

import java.util.*;
import java.util.stream.Collectors;

public class TicketFieldProcessor {

    public Map<String, Long> process(PuzzleInputModel puzzleInputModel, ValidTicketFilter validTicketFilter) {
        Map<String, Long> myTicket = new HashMap<>();

        List<Set<String>> possibleMappings = puzzleInputModel.derivePossibleMappings();

        final List<List<Long>> nearbyTickets = validTicketFilter.filterValid(puzzleInputModel);

        // let's go column for column through all the tickets
        for (int i = 0; i < possibleMappings.size(); i++) {
            Set<String> fieldsItCouldBe = new HashSet<>();

            int finalI = i;
            List<Long> allValuesForColumn = nearbyTickets.stream().map(list -> list.get(finalI)).collect(Collectors.toList());

            for (String field : possibleMappings.get(i)) {
                boolean valid = true;
                for (long ticketValue : allValuesForColumn) {
                    if (!puzzleInputModel.fieldIsAPossiblity(field, ticketValue)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) fieldsItCouldBe.add(field);
            }
            possibleMappings.set(i, fieldsItCouldBe);
        }

        final List<String> solution = deriveFinalFields(possibleMappings);

        for (int i = 0; i < solution.size(); i++) {
            myTicket.put(solution.get(i), puzzleInputModel.getMyTicket().get(i));
        }
        return myTicket;
    }

    private List<String> deriveFinalFields(List<Set<String>> possibleMappings) {
        List<String> processedDefinites = new ArrayList<>();

        while (!mappingsComplete(possibleMappings)) {
            for (Set<String> possibilities : possibleMappings) {
                if (possibilities.size() == 1) {
                    String knownDefinite = new ArrayList<>(possibilities).get(0);
                    if (!processedDefinites.contains(knownDefinite)) {
                        updateMappingsToRemove(knownDefinite, possibleMappings);
                        processedDefinites.add(knownDefinite);
                    }
                }
            }
        }

        return possibleMappings.stream().map(set -> new ArrayList<>(set).get(0)).collect(Collectors.toList());
    }

    private boolean mappingsComplete(List<Set<String>> possibleMappings) {
        return possibleMappings.stream().map(Collection::size).allMatch(i -> i == 1);
    }

    private void updateMappingsToRemove(String knownField, List<Set<String>> possibleMappings) {
        for (Set<String> possibilities : possibleMappings) {
            if (possibilities.size() > 1 && possibilities.contains(knownField)) {
                possibilities.remove(knownField);
            }
        }
    }


}
