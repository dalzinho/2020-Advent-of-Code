package day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PasswordValidator {

    private static final String MATCHER_REGEX = "(\\d{1,2})-(\\d{1,2}) ([a-z]): (.*)";

    abstract boolean validate(String s);

    protected Matcher getMatcher(String s) {
        Pattern pattern = Pattern.compile(MATCHER_REGEX);
        Matcher matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("doesn't compute");
        }

        return matcher;
    }

}
