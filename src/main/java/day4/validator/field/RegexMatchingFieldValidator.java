package day4.validator.field;

public class RegexMatchingFieldValidator extends FieldValidator {

    private final String regex;

    public RegexMatchingFieldValidator(String key, String regex) {
        super(key);
        this.regex = regex;
    }

    @Override
    protected boolean validateValue(String value) {
        return value.matches(regex);
    }
}
