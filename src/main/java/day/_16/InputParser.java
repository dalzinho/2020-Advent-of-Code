package day._16;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {

    private static final Pattern FIELDS_WITH_BOUNDS_PATTERN = Pattern.compile("([a-z ]+): (\\d+-\\d+) or (\\d+-\\d+)");
    private static final Pattern TICKET_PATTERN = Pattern.compile("(\\d+,?)+");

    public PuzzleInputModel parse(List<String> input) {
        boolean fieldWithBoundsComplete = false;
        boolean myTicketComplete = false;

        Map<String, List<TicketValueBounds>> fieldsWithBounds = new HashMap<>();
        List<Long> myTicket = null;
        List<List<Long>> nearbyTickets = new ArrayList<>();

        for (String s : input) {
            if (!fieldWithBoundsComplete) {
                Matcher m = FIELDS_WITH_BOUNDS_PATTERN.matcher(s);

                if (m.matches()) {
                    String field = m.group(1);
                    TicketValueBounds tvb1 = boundsOf(m.group(2));
                    TicketValueBounds tvb2 = boundsOf(m.group(3));
                    fieldsWithBounds.put(field, Arrays.asList(tvb1, tvb2));
                } else {
                    fieldWithBoundsComplete = true;
                }
            }

            if ("nearby tickets:".equals(s)) {
                myTicketComplete = true;
            }

            Matcher m = TICKET_PATTERN.matcher(s);

            if (m.matches()) {
                List<Long> ticket = ticketOf(s);
                if (myTicketComplete) {
                    nearbyTickets.add(ticket);
                } else {
                    myTicket = ticket;
                }
            }
        }

        PuzzleInputModel pim = new PuzzleInputModel();
        pim.setFieldWithBounds(fieldsWithBounds);
        pim.setMyTicket(myTicket);
        pim.setNearbyTickets(nearbyTickets);
        return pim;
    }


    private List<Long> ticketOf(String input) {
        return Arrays.stream(input.split(",")).map(Long::parseLong).collect(Collectors.toList());
    }

    private TicketValueBounds boundsOf(String input) {
        final String[] split = input.split("-");
        long low = Long.parseLong(split[0]);
        long high = Long.parseLong(split[1]);

        return new TicketValueBounds(low, high);

    }
}
