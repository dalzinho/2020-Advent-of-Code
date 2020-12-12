package day._12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class RainRisk {

    private static final Map<Long, String> HEADINGS;

    static {
        HEADINGS = new HashMap<>();
        HEADINGS.put(0L, "N");
        HEADINGS.put(90L, "E");
        HEADINGS.put(180L, "S");
        HEADINGS.put(270L, "W");
    }

    public long solve(List<String> testInputs) {

        Position shipPosition = new Position();

        for (String input : testInputs) {
            Command c = new Command(input);

            String instruction = c.instruction;
            int parameter = c.parameter;

            if (HEADINGS.containsValue(instruction) || instruction.equals("F")) {
                if (instruction.equals("F")) {
                    instruction = HEADINGS.get(shipPosition.getHeading());
                }
                if (Arrays.asList("N", "S").contains(instruction)) {
                    shipPosition.shiftY(instruction.equals("N") ? parameter : parameter * -1);
                } else {
                    shipPosition.shiftX(instruction.equals("E") ? parameter : parameter * -1);
                }
            } else if (Arrays.asList("L", "R").contains(instruction)) {
                final int turn = instruction.equals("R") ? parameter : parameter * -1;
                shipPosition.rotate(turn);
            }
        }

        return abs(shipPosition.getX()) + abs(shipPosition.getY());
    }

    public long solve2(List<String> inputs) {

        Position shipPosition = new Position();
        Position waypointPosition = new Position(10, 1);

        for (String input : inputs) {
            final Command c = new Command(input);

            String instruction = c.instruction;
            int parameter = c.parameter;

            if (instruction.equals("F")) {
                long nextX = waypointPosition.getX() * parameter;
                long nextY = waypointPosition.getY() * parameter;

                shipPosition.shiftX(nextX);
                shipPosition.shiftY(nextY);
            } else if (HEADINGS.containsValue(instruction)) {
                if (Arrays.asList("N", "S").contains(instruction)) {
                    waypointPosition.shiftY(instruction.equals("N") ? parameter : parameter * -1);
                } else {
                    waypointPosition.shiftX(instruction.equals("E") ? parameter : parameter * -1);
                }
            } else {
                int param = instruction.equals("L") ? parameter * -1 : parameter;
                waypointPosition = new PositionRotator().rotate(waypointPosition, param);
            }
        }
        return abs(shipPosition.getX()) + abs(shipPosition.getY());
    }

}
