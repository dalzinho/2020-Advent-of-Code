package day2;

import java.util.regex.Matcher;

public class BitwiseCharacterValidator extends PasswordValidator {

    @Override
    boolean validate(String s) {
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
