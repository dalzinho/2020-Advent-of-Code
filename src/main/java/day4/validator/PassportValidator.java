package day4.validator;

import java.util.*;

public abstract class PassportValidator {

    protected static final Set<String> REQUIRED_FIELDS;

    static {
        REQUIRED_FIELDS = new HashSet<>();
        final List<String> fields = Arrays.asList("ecl", "pid", "eyr", "hcl", "iyr", "hgt", "byr");
        REQUIRED_FIELDS.addAll(fields);
    }

    public abstract boolean validate(Map<String, String> passport);

}
