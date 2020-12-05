package day._4;

import day._4.validator.PassportValidator;
import util.Solution;

import java.util.List;

public class PassportProcessingSolution implements Solution<String, Long> {

    private final PassportInputFlattener passportInputFlattener;
    private final PassportInputMapper passportInputMapper;
    private final PassportValidator passportValidator;

    public PassportProcessingSolution(PassportInputFlattener passportInputFlattener, PassportInputMapper passportInputMapper, PassportValidator passportValidator) {
        this.passportInputFlattener = passportInputFlattener;
        this.passportInputMapper = passportInputMapper;
        this.passportValidator = passportValidator;
    }

    public Long solve(List<String> inputs) {
        return passportInputFlattener.flatten(inputs)
                .stream()
                .map(passportInputMapper::mapInputToPassport)
                .filter(passportValidator::validate)
                .count();
    }

}
