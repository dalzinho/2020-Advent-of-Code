package day._8;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandheldHaltingSolution {

    public long solve(List<String> inputs) {
        final List<Command> commands = parseInputs(inputs);
        return execute(commands);

    }

    private long execute(List<Command> commands) {
        List<Integer> executedLines = new ArrayList<>();

        int executionLine = 0;
        int accumulator = 0;

        while (executionLine < commands.size()) {
            if (executedLines.contains(executionLine)) {
                throw new IllegalArgumentException("tried to repeat line: " + executionLine + " | accumulator : " + accumulator);
            }

            final Command command = commands.get(executionLine);
            String action = command.action;
            int executionIncrement = 1;

            executedLines.add(executionLine);
            if (action.equals("acc")) {
                accumulator += command.param;
            } else if (action.equals("jmp")) {
                executionIncrement = command.param;
            }
            executionLine += executionIncrement;
        }

        return accumulator;
    }

    private List<Command> parseInputs(List<String> inputs) {
        final Pattern commandPattern = Pattern.compile("(nop|acc|jmp) ([\\-\\+]\\d+)");
        Matcher matcher;

        List<Command> commands = new ArrayList<>();

        for (String input : inputs) {
            matcher = commandPattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("command failed to match pattern: " + input);
            }
            Command command = new Command();
            command.action = matcher.group(1);
            command.param = Integer.parseInt(matcher.group(2));

            commands.add(command);
        }
        return commands;
    }

    public static class Command {
        String action;
        int param;
    }

    public long solve2(List<String> inputs) {

        for (int i = 0; i < inputs.size(); i++) {
            final List<Command> commands = parseInputs(inputs);
            Command command = commands.get(i);

            boolean changed = false;

            if (command.action.equals("nop")) {
                command.action = "jmp";
                changed = true;
            } else if (command.action.equals("jmp")) {
                command.action = "nop";
                changed = true;
            }

            if (changed) {
                try {
                    return execute(commands);
                } catch (IllegalArgumentException e) {
                    System.err.println(e);
                }
            }
        }
        return 0;
    }




}
