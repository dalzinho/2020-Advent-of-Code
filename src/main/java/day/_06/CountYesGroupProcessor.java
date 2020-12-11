package day._06;

import util.ResultProcessor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CountYesGroupProcessor implements ResultProcessor<String, Long> {

    public Long process(List<String> answers) {
        return answers.stream()
                .map(answer -> Arrays.asList(answer.split("")))
                .flatMap(Collection::stream)
                .distinct()
                .count();

    }
}
