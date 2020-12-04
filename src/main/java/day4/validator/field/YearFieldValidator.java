package day4.validator.field;

public class YearFieldValidator extends FieldValidator {

    private final int minYear;
    private final int maxYear;

    public YearFieldValidator(String key, int minYear, int maxYear) {
        super(key);
        this.minYear = minYear;
        this.maxYear = maxYear;
    }

    @Override
    protected boolean validateValue(String value) {
        final int year = Integer.parseInt(value);
        return year >= minYear && year <= maxYear;
    }
}
