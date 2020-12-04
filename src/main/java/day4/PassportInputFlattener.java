package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassportInputFlattener {

    public List<List<String>> flatten(List<String> inputs) {
        List<List<String>> output = new ArrayList<>();

        List<String> list = new ArrayList<>();

        for (String input : inputs) {
            if (input.isEmpty() && !list.isEmpty()) {
                output.add(list);
                list = new ArrayList<>();
                continue;
            }

            final String[] splitLine = input.split(" ");
            list.addAll(Arrays.asList(splitLine));
        }

        if (!list.isEmpty()) {
            output.add(list);
        }

        return output;
    }
}
