package day4.validator.field;

public class HeightFieldValidator extends FieldValidator {

    public HeightFieldValidator(String key) {
        super(key);
    }

    @Override
    protected boolean validateValue(String value) {
        String heightUnit = "";
        if (value.endsWith("cm")) {
            heightUnit = "cm";
        } else if (value.endsWith("in")) {
            heightUnit = "in";
        } else {
            return false;
        }

        final String heightNumber = value.replaceAll("[a-z]", "");
        int height = Integer.parseInt(heightNumber);

        boolean isValid = false;
        if (heightUnit.equals("cm")) {
            isValid = height >= 150 && height <= 193;
        } else {
            isValid = height >= 59 && height <= 76;
        }
        return isValid;
    }
}
