package day4.validator.field;

import java.util.Arrays;

public class EyeColourFieldValidator extends FieldValidator {

    public EyeColourFieldValidator(String key) {
        super(key);
    }

    @Override
    protected boolean validateValue(String value) {
        return Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value);
    }
}
