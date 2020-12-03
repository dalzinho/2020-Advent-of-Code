package day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPhilosophy {

    public long processRuleSetOne(List<String> inputs) {
        return inputs.stream()
                .filter(this::validateRuleSetOne)
                .count();
    }

    private boolean validateRuleSetOne(String s) {
        Matcher matcher = getMatcher(s);
        int lowBound = Integer.parseInt(matcher.group(1));
        int highBound = Integer.parseInt(matcher.group(2));
        String matchingCharacter = matcher.group(3);
        String password = matcher.group(4);

        long count = Arrays.stream(password.split(""))
                .filter(letter -> letter.equals(matchingCharacter))
                .count();

        return count >= lowBound && count <= highBound;
    }

    private Matcher getMatcher(String s) {
        Pattern pattern = Pattern.compile("(\\d{1,2})-(\\d{1,2}) ([a-z]): (.*)");
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("doesn't compute");
        }
        return matcher;
    }

    public long processRuleSetTwo(List<String> inputs) {
        return inputs.stream()
                .filter(this::validateRuleSetTwo)
                .count();
    }

    private boolean validateRuleSetTwo(String s) {
        Matcher matcher = getMatcher(s);
        int indexOne = Integer.parseInt(matcher.group(1)) - 1;
        int indexTwo = Integer.parseInt(matcher.group(2)) - 1;
        String matchingCharacter = matcher.group(3);
        String password = matcher.group(4);

        final String s1 = Character.toString(password.charAt(indexOne));
        final String s2 = Character.toString(password.charAt(indexTwo));

        return s1.equals(matchingCharacter) ^ s2.equals(matchingCharacter);
    }
}
