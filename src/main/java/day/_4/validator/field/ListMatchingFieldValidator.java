package day._4.validator.field;

import java.util.List;

public class ListMatchingFieldValidator extends FieldValidator {

    private final List<String> fieldsToMatch;

    public ListMatchingFieldValidator(String key, List<String> fieldsToMatch) {
        super(key);
        this.fieldsToMatch = fieldsToMatch;
    }

    @Override
    protected boolean validateValue(String value) {
        return fieldsToMatch.contains(value);
    }
}
