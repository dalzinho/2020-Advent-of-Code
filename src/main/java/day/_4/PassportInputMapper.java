package day._4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassportInputMapper {

    public Map<String, String> mapInputToPassport(List<String> inputs) {
        Map<String, String> map = new HashMap<>();

        for (String input : inputs) {
            final String[] split = input.split(":");
            map.put(split[0], split[1]);
        }

        return map;
    }
}
