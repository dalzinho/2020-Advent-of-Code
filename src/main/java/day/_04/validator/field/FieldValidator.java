package day._04.validator.field;

import java.util.Map;

public abstract class FieldValidator {

    private String key;

    protected FieldValidator(String key) {
        this.key = key;
    }

    public boolean validateField(Map<String, String> passport) {
        String value = passport.get(key);

        if (value == null) {
            return false;
        }

        return validateValue(value);
    }

    protected abstract boolean validateValue(String value);
}
