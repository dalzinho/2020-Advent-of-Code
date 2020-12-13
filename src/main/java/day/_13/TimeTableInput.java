package day._13;

import lombok.Data;

import java.util.List;

@Data
public class TimeTableInput {

    private long arrivalTime;
    private List<Long> busFrequencies;
}
