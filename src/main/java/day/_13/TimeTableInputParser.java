package day._13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TimeTableInputParser {

    public TimeTableInput parse(List<String> input) {
        TimeTableInput timeTableInput = new TimeTableInput();

        long arrivalTime = Long.parseLong(input.get(0));
        List<Long> busFrequencies = Arrays.stream(input.get(1).split(","))
                .map(l -> "x".equals(l) ? -1L : Long.parseLong(l))
                .collect(Collectors.toList());

        timeTableInput.setArrivalTime(arrivalTime);
        timeTableInput.setBusFrequencies(busFrequencies);

        return timeTableInput;
    }
}
