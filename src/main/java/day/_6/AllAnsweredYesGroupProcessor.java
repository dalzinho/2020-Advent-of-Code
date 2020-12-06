package day._6;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class AllAnsweredYesGroupProcessor implements GroupProcessor {

    public long process(List<String> answers) {
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
