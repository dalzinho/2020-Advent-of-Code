package day._16;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class PuzzleInputModel {

    private Map<String, List<TicketValueBounds>> fieldWithBounds;
    private List<Long> myTicket;
    private List<List<Long>> nearbyTickets;

    public List<Set<String>> derivePossibleMappings() {
        List<Set<String>> possibilities = new ArrayList<>();
        for (long ignored : myTicket) {
            possibilities.add(fieldWithBounds.keySet());
        }
        return possibilities;
    }

    public boolean fieldIsAPossiblity(String field, Long value) {
        List<TicketValueBounds> bounds = fieldWithBounds.get(field);
        return bounds.stream()
                .map(TicketValueBounds::range)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .contains(value);
    }
}
