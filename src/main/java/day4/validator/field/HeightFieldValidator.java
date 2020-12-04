package day4.validator.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightFieldValidator extends FieldValidator {

    public HeightFieldValidator(String key) {
        super(key);
    }

    @Override
    protected boolean validateValue(String value) {

        final Pattern pattern = Pattern.compile("(\\d+) ?(cm|in)");
        final Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            return false;
        }

        int heightValue = Integer.parseInt(matcher.group(1));
        String heightUnit = matcher.group(2);

        return heightUnit.equals("cm")
                ? validateHeightByUnit(heightValue, 150, 193)
                : validateHeightByUnit(heightValue, 59, 76);
    }

    private boolean validateHeightByUnit(int height, int lowBound, int highBound) {
        return height >= lowBound && height <= highBound;
    }

}
