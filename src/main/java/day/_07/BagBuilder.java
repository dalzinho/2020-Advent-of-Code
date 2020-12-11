package day._07;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BagBuilder {

    public Map<String, Bag> buildBags(List<String> input) {
        Map<String, Bag> bagsMap = new HashMap<>();

        for (String line : input) {
            String bagName = line.split(" contain ")[0].replaceAll("bags", "").trim();
            Bag bag = bagsMap.computeIfAbsent(bagName, Bag::new);
            Map<String, Integer> contains = Arrays.stream(line.split(" contain ")[1].split(", "))
                    .map(s -> s.replaceAll("bags?\\.?", "").trim())
                    .map(s -> s.split(" ", 2))
                    .collect(Collectors.toMap(s -> s[1], s -> NumberUtils.toInt(s[0])));

            contains.forEach((n, i) -> {
                if (i == 0) return;
                Bag b = bagsMap.computeIfAbsent(n, Bag::new);
                bag.getContents().put(b, i);
            });
        }

        return bagsMap;
    }
}
