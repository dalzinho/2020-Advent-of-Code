package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFlattener {

    public List<List<String>> flatten(List<String> inputs, String splitLineOn) {
        List<List<String>> output = new ArrayList<>();

        List<String> list = new ArrayList<>();

        for (String input : inputs) {
            if (input.isEmpty() && !list.isEmpty()) {
                output.add(list);
                list = new ArrayList<>();
                continue;
            }

            final String[] splitLine = input.split(splitLineOn);
            list.addAll(Arrays.asList(splitLine));
        }

        if (!list.isEmpty()) {
            output.add(list);
        }

        return output;
    }
}
