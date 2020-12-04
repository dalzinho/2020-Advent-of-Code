package day4.validator.field;

public class HairColourFieldValidator extends FieldValidator {

    public HairColourFieldValidator(String key) {
        super(key);
    }

    @Override
    protected boolean validateValue(String value) {
        return value.matches("#[0-9a-z]{6}");
    }
}
