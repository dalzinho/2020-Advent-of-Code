package day._4.validator;

import day._4.validator.field.FieldValidator;
import day._4.validator.field.FieldValidatorFactory;

import java.util.List;
import java.util.Map;

public class FieldsCheckedPassportValidator extends PassportValidator {

    @Override
    public boolean validate(Map<String, String> passport) {
        final List<FieldValidator> validators = FieldValidatorFactory.getValidators();

        return validators
                .stream()
                .filter(fieldValidator -> fieldValidator.validateField(passport))
                .count() == REQUIRED_FIELDS.size();
    }
}
