package day._2;

import java.util.Arrays;
import java.util.regex.Matcher;

public class CharacterCountValidator extends PasswordValidator  {

    @Override
    boolean validate(String s) {
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
}
