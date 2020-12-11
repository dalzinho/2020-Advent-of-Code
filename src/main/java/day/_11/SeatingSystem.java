package day._11;

import day._11.generator.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SeatingSystem {


    private final Generator generator;

    public SeatingSystem(Generator generator) {
        this.generator = generator;
    }

    public long solve(List<String> inputs) {
        List<List<String>> previousGeneration = new ArrayList<>();
        List<List<String>> currentGeneration = inputs.stream()
                .map(s -> s.split(""))
                .map(Arrays::asList)
                .collect(Collectors.toList());

        while (!previousGeneration.equals(currentGeneration)) {
            previousGeneration = currentGeneration;
            currentGeneration = generator.generate(currentGeneration);
        }

        return currentGeneration.stream()
                .flatMap(Collection::stream)
                .filter("#"::equals)
                .count();
    }


}
