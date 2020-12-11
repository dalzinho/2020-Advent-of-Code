package day._06;

import util.ResultProcessor;

import java.util.*;
import java.util.stream.Collectors;

public class AllAnsweredYesGroupProcessor implements ResultProcessor<String, Long> {

    public Long process(List<String> answers) {
        return answers.stream()
                .map(answer -> answer.split(""))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(String::valueOf, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == answers.size())
                .count();
    }
}
