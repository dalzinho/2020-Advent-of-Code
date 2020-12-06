package day._6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CountYesGroupProcessor implements GroupProcessor {

    public long process(List<String> answers) {
        return answers.stream()
                .map(answer -> Arrays.asList(answer.split("")))
                .flatMap(Collection::stream)
                .distinct()
                .count();

    }
}
