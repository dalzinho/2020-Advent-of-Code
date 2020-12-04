package day4.validator.field;

public class PassportIdFieldValidator extends FieldValidator {

    public PassportIdFieldValidator(String key) {
        super(key);
    }

    @Override
    protected boolean validateValue(String value) {
        return value.matches("\\d{9}");
    }
}
