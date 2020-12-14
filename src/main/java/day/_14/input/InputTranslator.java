package day._14.input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTranslator {

    public List<DockingDataInput> translateInputs(List<String> inputs) {
        List<DockingDataInput> translatedInputs = new ArrayList<>();
        final Pattern memPattern = Pattern.compile("mem\\[(\\d+)] = (\\d+)");

        DockingDataInput dockingDataInput = null;
        for (String input : inputs) {
            if (input.startsWith("mask")) {
                if (dockingDataInput != null) {
                    translatedInputs.add(dockingDataInput);
                }
                dockingDataInput = new DockingDataInput();
                String mask = input.split("=")[1].trim();
                dockingDataInput.setMask(mask);
            } else {
                final Matcher matcher = memPattern.matcher(input);
                if (matcher.matches()) {
                    dockingDataInput.addValues(matcher.group(1), matcher.group(2));
                }
            }
        }
        translatedInputs.add(dockingDataInput);

        return translatedInputs;
    }
}
