package day._5.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SeatPatternDecoder {

    public static final String ROW = "row";
    public static final String COLUMN = "column";

    public Map<String, List<Boolean>> decodeInput(String input) {
        Map<String, List<Boolean>> result = new HashMap<>();

        final Matcher match = match(input);

        result.put(ROW, transformToBoolean(match.group(1), "B"));
        result.put(COLUMN, transformToBoolean(match.group(2), "R"));

        return result;
    }

    private Matcher match(String input) {
        Pattern pattern = Pattern.compile("([FB]{7})([RL]{3})");
        final Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        return matcher;
    }

    private List<Boolean> transformToBoolean(String inputFragment, String trueValue) {
        return Arrays.stream(inputFragment.split(""))
                .map(letter -> letter.equals(trueValue))
                .collect(Collectors.toList());
    }
}
