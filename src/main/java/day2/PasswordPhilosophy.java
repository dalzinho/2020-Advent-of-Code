package day2;

import java.util.List;

public class PasswordPhilosophy {

    public long countMatches(List<String> inputs, PasswordValidator passwordValidator) {
        return inputs.stream()
                .filter(passwordValidator::validate)
                .count();
    }

}
