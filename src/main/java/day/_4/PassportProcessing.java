package day._4;

import day._4.validator.PassportValidator;

import java.util.List;

public class PassportProcessing {

    private final PassportInputFlattener passportInputFlattener;
    private final PassportInputMapper passportInputMapper;

    public PassportProcessing(PassportInputFlattener passportInputFlattener, PassportInputMapper passportInputMapper) {
        this.passportInputFlattener = passportInputFlattener;
        this.passportInputMapper = passportInputMapper;
    }

    public long validate(List<String> inputs, PassportValidator passportValidator) {
        return passportInputFlattener.flatten(inputs)
                .stream()
                .map(passportInputMapper::mapInputToPassport)
                .filter(passportValidator::validate)
                .count();
    }

}
