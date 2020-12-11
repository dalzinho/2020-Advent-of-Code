package day._02;

import util.Solution;

import java.util.List;

public class PasswordPhilosophy implements Solution<String, Long> {

    private PasswordValidator passwordValidator;

    public PasswordPhilosophy() {
    }

    public PasswordPhilosophy(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    public long countMatches(List<String> inputs, PasswordValidator passwordValidator) {
        return inputs.stream()
                .filter(passwordValidator::validate)
                .count();
    }

    @Override
    public Long solve(List<String> input) {
        return input.stream()
                .filter(passwordValidator::validate)
                .count();
    }
}
