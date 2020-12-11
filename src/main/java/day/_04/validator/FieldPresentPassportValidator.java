package day._04.validator;

import java.util.*;

public class FieldPresentPassportValidator extends PassportValidator {

    public boolean validate(Map<String, String> passport) {
        return passport.keySet()
                .stream()
                .filter(REQUIRED_FIELDS::contains)
                .count() == REQUIRED_FIELDS.size();
    }
}
