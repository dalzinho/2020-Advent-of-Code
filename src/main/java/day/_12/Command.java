package day._12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    String instruction;
    int parameter;

    public Command(String input) {
        final Pattern instructionPattern = Pattern.compile("([NESWFLR])(\\d+)");

        final Matcher instructionMatcher = instructionPattern.matcher(input);
        if (!instructionMatcher.matches()) {
            throw new IllegalArgumentException("invalid instruction: " + input);
        }

        this.instruction = instructionMatcher.group(1);
        this.parameter = Integer.parseInt(instructionMatcher.group(2));
    }

}
