package day._7;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Bag {

    private String name;
    private Map<Bag, Integer> contents;

    public Bag(String name) {
        this.name = name;
        this.contents = new HashMap<>();
    }

    boolean containsBag(Bag bag) {
        return contents.containsKey(bag) ||
                contents.keySet().stream().anyMatch(b -> b.containsBag(bag));
    }

    int countContained() {
        int c1 = this.contents.values().stream().mapToInt(i -> i).sum();
        int c2 = contents.entrySet().stream().mapToInt(e -> e.getKey().countContained() * e.getValue()).sum();
        return c1 + c2;
    }
}
