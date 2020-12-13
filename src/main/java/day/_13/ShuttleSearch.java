package day._13;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ShuttleSearch {

    private final TimeTableInputParser timeTableInputParser;

    public ShuttleSearch(TimeTableInputParser timeTableInputParser) {
        this.timeTableInputParser = timeTableInputParser;
    }

    public long solution1(List<String> strings) {
        final TimeTableInput timeTableInput = timeTableInputParser.parse(strings);

        long waitTime = Long.MAX_VALUE;
        long busNumber = Long.MAX_VALUE;

        for (Long frequency : timeTableInput.getBusFrequencies()) {
            if (frequency < 0) {
                continue;
            }

            long nextWaitTime = calculateWaitTime(timeTableInput.getArrivalTime(), frequency);

            if (nextWaitTime < waitTime) {
                waitTime = nextWaitTime;
                busNumber = frequency;
            }
        }

        return waitTime * busNumber;
    }

    private long calculateWaitTime(long waitingFromTimeStamp, long busFrequency) {
        long arrivalTime = 0;
        while (arrivalTime < waitingFromTimeStamp) {
            arrivalTime += busFrequency;
        }
        return arrivalTime - waitingFromTimeStamp;
    }

    public long solution2(List<String> inputs) {
        final TimeTableInput timeTableInput = timeTableInputParser.parse(inputs);
        List<Long> frequencies = timeTableInput.getBusFrequencies();

        long earliest = frequencies.get(0);
        long increment = 7L;

        for (int i = 1; i < frequencies.size(); i++) {
            List<Long> subList = frequencies.subList(0, i + 1);
            boolean nextFactorFound = false;

            AtomicLong nextFactor = new AtomicLong(earliest);

            while (!nextFactorFound) {

                final boolean iterationHasNextFactor = IntStream.range(0, subList.size())
                        .filter(j -> subList.get(j) > 0)
                        .mapToLong(j -> (nextFactor.get() + j) % subList.get(j))
                        .boxed()
                        .allMatch(l -> l == 0L);

                if (!iterationHasNextFactor) {
                    nextFactor.getAndAdd(increment);
                } else {
                    nextFactorFound = true;
                    earliest = nextFactor.get();
                    increment = subList.stream().mapToLong(Long::longValue).filter(l -> l > 0).reduce((a, b) -> a * b).getAsLong();
                }
            }


        }
        return earliest;
    }
}

