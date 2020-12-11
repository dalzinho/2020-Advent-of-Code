package day._04;

import day._04.validator.PassportValidator;
import util.InputFlattener;
import util.Solution;

import java.util.List;

public class PassportProcessingSolution implements Solution<String, Long> {

    private final InputFlattener inputFlattener;
    private final PassportInputMapper passportInputMapper;
    private final PassportValidator passportValidator;

    public PassportProcessingSolution(InputFlattener inputFlattener, PassportInputMapper passportInputMapper, PassportValidator passportValidator) {
        this.inputFlattener = inputFlattener;
        this.passportInputMapper = passportInputMapper;
        this.passportValidator = passportValidator;
    }

    public Long solve(List<String> inputs) {
        return inputFlattener.flatten(inputs, " ")
                .stream()
                .map(passportInputMapper::mapInputToPassport)
                .filter(passportValidator::validate)
                .count();
    }

}
